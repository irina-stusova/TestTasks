package com.company.lessons.lesson8;

public class StringLearn {

    //Задание 1: В каждом слове текста k-ю букву заменить заданным символом.
    // Если k больше длины слова, корректировку не выполнять.

    public void replaceLetter(int k, char letter) {
        String string = "Write once, run anywhere";
        String[] words = string.split("\\s*(\\s|,|!|\\.)\\s*");

        String[] replacedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            if (word.length() >= k) {
                word.setCharAt(k - 1, letter);
            }
            replacedWords[i] = String.valueOf(word);
        }
        String s = string;
        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], replacedWords[i]);
        }
//            string = new StringBuffer(string.replace(0, 4, replacedWords[0]));
//            string = new StringBuffer(string.replace(6, 9, replacedWords[1]));
//            string = new StringBuffer(string.replace(12, 14, replacedWords[2]));
//            string = new StringBuffer(string.replace(16, 23, replacedWords[3]));
//        }
        System.out.println(s);
    }

}




