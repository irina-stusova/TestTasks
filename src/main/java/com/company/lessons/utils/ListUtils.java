package com.company.lessons.utils;

import java.io.IOException;
import java.util.List;

public class ListUtils {
    //метод распечатывает список
    public static void printList(List<String> list, String delimiter) {
        for (String s : list) {
            System.out.print(s + delimiter);
        }
        System.out.println();
    }

    //метод преобразует список строк в многомерный массив, где внешний массив - массив строк,
    // внутренние массивы - массивы отдельных слов / символов в каждой строке

    public static String[][] convertListToArray(List<String> list, String delimiter) throws IOException {
        String[][] arr = new String[list.size()][];
        for (int i = 0, s = 0; i < list.size(); i++, s++) {
                arr[i] = list.get(s).split(delimiter);
            }
        return arr;
    }
}
