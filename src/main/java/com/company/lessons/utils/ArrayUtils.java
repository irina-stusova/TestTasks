package com.company.lessons.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    //метод распечатывает многомерный массив
    public static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //метод преобразует многомерный массив в список
    public static List<String> convertArrayToList(String[][] arr) {
        List<String> lout = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                lout.add(arr[i][j]);
            }
            lout.add("\n");
        }
        return lout;
    }
}
