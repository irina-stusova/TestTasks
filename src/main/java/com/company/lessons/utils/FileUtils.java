package com.company.lessons.utils;

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

    //метод считывает целые числа из файла в список
    public static List<Integer> readIntsFromFile(String filePath) {
        List<Integer> lout = new ArrayList<>();
        File file = new File(filePath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = br.readLine()) != null) {
                lout.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lout;
    }

    // метод записывает список строк в новый файл
    public static void writeListToFile(List<String> list, String filePath) throws IOException {
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
                fileWriter.write(s + "\r\n");
            }
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

