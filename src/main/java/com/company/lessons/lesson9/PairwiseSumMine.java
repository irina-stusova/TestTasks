package com.company.lessons.lesson9;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PairwiseSumMine {/*
    Random random = new Random();
    Set<Integer> numbersSet = new HashSet<>();
    int i = 0;
        while (i < 20){
        numbersSet.add(random.nextInt(100));
        i=numbersSet.size();
    }

    Integer[] numbersSetToArray = numbersSet.toArray(new Integer[numbersSet.size()]); //массив из 20 элем-в

    //проверка финального значения:
    int sum = 0;

        for (int i = 0; i < numbersSetToArray.length; i++) {
        sum += numbersSetToArray[i];
    }
        System.out.println("Число для проверки: " + sum);

    Integer[] arrayAfterSum1 = new Integer[10]; //массив из 10 элем-в
    int sum1 = 0;

        for (int i = 0, j = 0; i <= numbersSetToArray.length - 2; i += 2, j++) {
        sum1 = numbersSetToArray[i] + numbersSetToArray[i + 1];
        arrayAfterSum1[j] = sum1;
    }
    //arrayAfterSum1[arrayAfterSum1.length - 1] = numbersSetToArray[numbersSetToArray.length - 1];


    Integer[] arrayAfterSum2 = new Integer[5]; //массив из 5 элем-в
    int sum2 = 0;

        for (int i = 0, j = 0; i <= arrayAfterSum1.length - 2; i += 2, j++) {
        sum2 = arrayAfterSum1[i] + arrayAfterSum1[i + 1];
        arrayAfterSum2[j] = sum2;
    }

    Integer[] arrayAfterSum3 = new Integer[3]; //массив из 3 элем-в
    int sum3 = 0;

        for (int i = 0, j = 0; i < arrayAfterSum2.length - 2; i += 2, j++) {
        sum3 = arrayAfterSum2[i] + arrayAfterSum2[i + 1];
        arrayAfterSum3[j] = sum3;
    }
    arrayAfterSum3[arrayAfterSum3.length - 1] = arrayAfterSum2[arrayAfterSum2.length - 1];

    Integer[] arrayAfterSum4 = new Integer[2]; //массив из 2 элем-в
    int sum4 = 0;

        for (int i = 0, j = 0; i < arrayAfterSum3.length - 1; i += 2, j++) {
        sum4 = arrayAfterSum3[i] + arrayAfterSum3[i + 1];
        arrayAfterSum4[j] = sum4;
    }
    arrayAfterSum4[arrayAfterSum4.length - 1] = arrayAfterSum3[arrayAfterSum3.length - 1];

    Integer[] arrayAfterSum5 = new Integer[1]; //массив из 1 элем-та
    int sum5 = 0;

        for (int i = 0, j = 0; i < arrayAfterSum4.length - 1; i++, j++) {
        sum5 = arrayAfterSum4[i] + arrayAfterSum4[i + 1];
        arrayAfterSum5[j] = sum5;
    }


        System.out.println("Решение задачи: " + sum5);*/
}
