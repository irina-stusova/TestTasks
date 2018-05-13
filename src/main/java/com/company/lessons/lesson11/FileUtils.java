package com.company.lessons.lesson11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    //метод считывает строки из файла в список
    public static List<String> readFileAsList(String filePath) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lout;
    }

    // метод записывает список строк в новый файл

    public static void writeToFile(List<String> list, String filePath) throws IOException {
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

    //метод распечатывает многомерный массив
    public static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //метод распечатывает список
    public static void printList(List<String> list) {
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}

