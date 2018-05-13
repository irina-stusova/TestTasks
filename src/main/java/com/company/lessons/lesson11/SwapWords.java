package com.company.lessons.lesson11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Задание1. Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.

public class SwapWords {

    //метод преобразует список строк в многомерный массив, где внешний массив - массив строк,
    // внутренние массивы - массивы отдельных слов в каждой строке

    public String[][] convertListToArray(List<String> list) {

        String[][] arr = new String[list.size()][];
        for (int i = 0, s = 0; i < list.size(); i++, s++) {
            arr[i] = list.get(s).split("\\s*(\\s|,|\\.|\\?)\\s*");
        }
        return arr;
    }

    //метод меняет первый и последний элемент (слово) в каждом внутреннем массиве

    public String[][] getArrayWithSwappedWords(String[][] arr) {

        String swap;
        for (int i = 0; i < arr.length; i++) {
            swap = arr[i][0];
            arr[i][0] = arr[i][arr[i].length - 1];
            arr[i][arr[i].length - 1] = swap;
        }
        return arr;
    }

    //метод преобразует обратно многомерный массив с поменянными местами словами в список
    public List<String> convertArrayWithSwappedWordsToList(String[][] arr) {
        List<String> lout = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                lout.add(arr[i][j] + " ");
            }
            lout.add("\n");
        }
        return lout;
    }
}
