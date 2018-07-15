package com.penske.lessons.lesson11;

// Задание1. Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.

public class SwapWords {

    //метод меняет 1-й и 3-й элемент (слово) в каждом внутреннем массиве

    public String[][] getArrayWithSwappedWords(String[][] arr, int index1, int index2) {

        String swap;

        for (int i = 0; i < arr.length; i++) {
            swap = arr[i][index1];
            arr[i][index1] = arr[i][index2];
            arr[i][index2] = swap;
        }
        return arr;
    }

//    //метод меняет первый и последний элемент (слово) в каждом внутреннем массиве
//
//    public String[][] getArrayWithSwappedWords(String[][] arr) {
//
//        String swap;
//        for (int i = 0; i < arr.length; i++) {
//            swap = arr[i][0];
//            arr[i][0] = arr[i][arr[i].length - 1];
//            arr[i][arr[i].length - 1] = swap;
//        }
//        return arr;
//    }
}
