package com.company.lessons.lesson9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Задание 3. Дано стихотворение в виде строки.
// Занести стихотворение в список (разделитель символ абзаца \n).
// Провести сортировку по возрастанию длин строк.

public class Patter {

    public ArrayList<String> getListOfStringsSorted() {
        String str = "Крошечные котики ели тортики.\nОчень любят тортики крошечные котики.\nЛапками котики крошили тортики.\nКотики от тортиков наполнили животики.";
        String[] arr = str.split("\n");
        ArrayList<String> list = new ArrayList<>();
        for (String a : arr) {
            list.add(a);
        }

        //записывать строки в TreeMap instead of array, длина - key, text - value


        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return list;
    }

    public static void printListOfStringsSorted(ArrayList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

}

