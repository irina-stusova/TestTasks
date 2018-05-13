package com.company.lessons.lesson8;

import java.util.*;
import java.util.Map.Entry;

public class SortMapByValue {
    public static boolean ASC = true;
    public static boolean DESC = false;

    public static Map<Character, Integer> sortByComparator(Map<Character, Integer> mapUnique, final boolean order) {
        //Создаю list для хранения только значений (values) из mapUnique
        List<Entry<Character, Integer>> list = new LinkedList<>(mapUnique.entrySet());

        // Сортирую list по значениям (values) в зависимости от константы (DESC / ASC), переданной в метод
        Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
            public int compare(Entry<Character, Integer> o1,
                               Entry<Character, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Получаю отсортированную sortedMap типа LinkedHashMap, содержащую ключ - значение
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    //print the whole hashmap
    public static void printMap(Map<Character, Integer> map) {
        for (Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Count: " + entry.getValue());
        }
    }

    // печатаю первые num пар ключ-значение
    public static void printPartOfMap(Map<Character, Integer> map, int num) {
        int i = 0;
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            if (i < num) {
                System.out.println("Key: " + item.getKey() + " Count: " + item.getValue());
            } else {
                break;
            }
            i++;
        }
    }

}
