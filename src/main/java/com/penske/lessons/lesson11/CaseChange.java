package com.penske.lessons.lesson11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Задание 4. Считать стихотворение украинского/английского/русского автора
// и в каждом слове длиннее двух символов все строчные символы заменить прописными.

public class CaseChange {

    // метод в каждом слове длиннее двух символов все строчные символы заменяет прописными.

    public List<String> toUpperCase(List<String> list, int count) throws IOException {
        List<String> lout = new ArrayList<>();
        for (String element : list) {
            if (element.length() > count) {
                lout.add(element.toUpperCase());
            } else {
                lout.add(element);
            }
        }
        return lout;
    }
}
