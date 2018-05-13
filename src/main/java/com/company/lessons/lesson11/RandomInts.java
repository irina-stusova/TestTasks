package com.company.lessons.lesson11;

import java.io.*;
import java.util.*;

//Задание 2. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

public class RandomInts {

    //метод генерит случайные целые числа в коллекцию List типа Integer и потом конвертирует Integer в String
    public List<String> generateRandomList(int count) {
        List<Integer> listInt = new ArrayList<>();
        while (count > listInt.size()) {
            listInt.add(new Random().nextInt(count + 5));
        }
        List<String> listStr = new ArrayList<String>(listInt.size());
        for (Integer i : listInt) {
            listStr.add(i.toString());
        }
        return listStr;
    }

    // метод записывает список целых чисел (как строк) в новый файл

    public static void writeNumbersToFile(List<String> list, String filePath) throws IOException {
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

    //метод считывает целые числа из файла в список
    public List<Integer> readFromFile(String filePath) {
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

    //метод сортирует по возрастанию числа в списке типа Integer и потом конвертирует Integer в String
    public List<String> getSortedList(List<Integer> listInt) {
        boolean isSorted = false;
        int swap;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < listInt.size() - 1; i++) {

                if (listInt.get(i) > listInt.get(i + 1)) {
                    isSorted = false;
                    swap = listInt.get(i);
                    listInt.set(i, listInt.get(i + 1));
                    listInt.set((i + 1), swap);
                }
            }
        }
        List<String> listStr = new ArrayList<>(listInt.size());
        for (Integer i : listInt) {
            listStr.add(i.toString());
        }
        return listStr;
    }
}