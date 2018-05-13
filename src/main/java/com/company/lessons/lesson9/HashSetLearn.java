package com.company.lessons.lesson9;

import java.util.HashSet;
import java.util.Set;


//Задание 1. Задана строка с текстом на английском языке. Выделить все различные слова.
//Слова, отличающиеся только регистром букв, считать одинаковыми.
//Использовать класс HashSet.

public class HashSetLearn {

    public Set<String> getUniqueWords()
    {
        String str = "Yesterday is history, tomorrow IS a mystery, today iS A gift of God, which Is why we call it the present.";
        String[] words = str.split("\\s*(\\s|,|\\.)\\s*");

        Set<String> strAsSet = new HashSet<>();
        for (String s : words) {
            strAsSet.add(s.toLowerCase());
        }
        return strAsSet;
    }

    public static void printUniqueWords(Set <String> set) {
        for (String s : set) {
            System.out.println(s);
        }
    }

}
