package com.company.lessons.lesson11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaFileReversed {
    //Задание 3. Прочитать текст Java-программы (какого-то класса)
    // и записать в другой файл в обратном порядке символы каждой строки.

    //метод считывает текст Java программы в список
    public List<String> readFileAsList(String filePath) throws IOException {
        List<String> lout = new ArrayList<>();
        File file = new File(filePath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = br.readLine()) != null) {
                lout.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lout;
    }

    //метод преобразует список строк в многомерный массив, где внешний массив - массив строк,
    // внутренние массивы - массивы отдельных символов в каждой строке

    public String[][] getListAsArray(List<String> list) throws IOException {

        String[][] arr = new String[list.size()][];
        for (int i = 0, s = 0; i < list.size(); i++, s++) {
            arr[i] = list.get(s).split("");
        }
        return arr;
    }

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
            for (int j = 0; j < arr[i].length; j++) {
                lout.add(arr[i][j] + " ");
            }
            lout.add("\n");
        }
        return lout;
    }
    //метод распечатывает многомерный масссив (текст с поменянными местами символами в каждой строке)

    public void printArray(String[][] arr) {
        System.out.println("Print multi-dimensional array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //метод преобразует обратно многомерный массив с поменянными местами символами в каждой строке в список
    public List<String> getListReversed(String[][] arr) {
        List<String> lout = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                lout.add(arr[i][j] + " ");
            }
            lout.add("\n");
        }
        return lout;
    }
// метод записывает новый текст в новый файл

    public void writeToFile(List<String> list, String filePath) throws IOException {
        FileWriter fileWriter = null;
        File file = new File(filePath);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter = new FileWriter(file);
            for (String s : list) {
                fileWriter.write(s);
            }
            fileWriter.append("\r\n");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
