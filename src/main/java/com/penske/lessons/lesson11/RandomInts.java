package com.penske.lessons.lesson11;

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