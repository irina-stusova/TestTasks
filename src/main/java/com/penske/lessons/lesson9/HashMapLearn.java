package com.penske.lessons.lesson9;


//    Задание 2. Задана строка с текстом на английском языке. Выделить все различные слова.
//    Для каждого слова подсчитать частоту его встречаемости. Слова, отличающиеся регистром букв, считать различными. Использовать класс HashMap.

import java.util.HashMap;
import java.util.Map;

public class HashMapLearn {

    public Map<String, Integer> getUniqueWordsAndCounts() {

        String str = "Yesterday is history, tomorrow IS a mystery, today iS A gift of God, which Is why we call it the present.";
        String[] wordsAll = str.split("\\s*(\\s|,|\\.)\\s*");
        Map<String, Integer> wordsUnique = new HashMap<>();

        for (String s : wordsAll) {
            if (wordsUnique.containsKey(s)) {
                wordsUnique.put(s, wordsUnique.get(s)+1);
            } else {
                wordsUnique.put(s, 1);
            }
        }
        return wordsUnique;
    }
//    public static void printUniqueWordsAndCounts(Map<String, Integer> map) {
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(String.format("Word: '%s', Count: '%d'", entry.getKey(), entry.getValue()));
//        }
//    }
    public static <T, V> void printUniqueWordsAndCounts (Map<T, V> map, boolean printOnlyValue){
        for (Map.Entry<T, V> entry: map.entrySet()){
            if (printOnlyValue){
                System.out.println(String.format("Count: '%d'", entry.getValue()));
            } else {
                System.out.println(String.format("Word: '%s', Count: '%d'", entry.getKey(), entry.getValue()));
            }
        }
    }
}
