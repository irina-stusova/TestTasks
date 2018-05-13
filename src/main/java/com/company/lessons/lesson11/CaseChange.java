package com.company.lessons.lesson11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Задание 4. Считать стихотворение украинского/английского/русского автора
// и в каждом слове длиннее двух символов все строчные символы заменить прописными.

public class CaseChange {

    //метод считывает строки из файла в список

    public List<String> readFileAsList(String filePath) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(filePath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    //метод преобразует список строк в многомерный массив, где внешний массив - массив строк,
    // внутренние массивы - массивы отдельных слов в каждой строке

    public String[][] convertListToArray(List<String> list) throws IOException {
        String[][] arr = new String[list.size()][];
        for (int i = 0, s = 0; i < list.size(); i++, s++) {
            arr[i] = list.get(s).split("\\s*(\\s|,|\"|\\.|\\?)\\s*");
        }
        return arr;
    }

    //метод преобразует многомерный массив в коллекцию отдельных слов

    public List<String> convertArrayToList(String[][] arr) throws IOException {
        List<String> lout = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                lout.add(arr[i][j]);
            }
        }
        return lout;
    }

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
