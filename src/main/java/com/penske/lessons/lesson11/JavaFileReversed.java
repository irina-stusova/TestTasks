package com.penske.lessons.lesson11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaFileReversed {
    //Задание 3. Прочитать текст Java-программы (какого-то класса)
    // и записать в другой файл в обратном порядке символы каждой строки.


    //метод меняет порядок всех символов в каждой строке списка

    public List<String> getTextReversed(String[][] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length / 2; j++) {
                String swap = arr[i][j];
                arr[i][j] = arr[i][arr[i].length - 1 - j];
                arr[i][arr[i].length - 1 - j] = swap;
            }
        }

        List<String> lout = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String sb = "";
            for (int j = 0; j < arr[i].length; j++) {
                sb += arr[i][j];
//                lout.add(arr[i][j]);
            }
            lout.add(sb);
        }
        return lout;
    }
}
