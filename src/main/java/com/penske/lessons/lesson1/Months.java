package com.penske.lessons.lesson1;

import java.util.ArrayList;


public class Months {

    private ArrayList<String> listMonths = new ArrayList<String>() {
        {
            add("January");
            add("February");
            add("March");
            add("April");
            add("May");
            add("June");
            add("July");
            add("August");
            add("September");
            add("October");
            add("November");
            add("December");
        }
    };

    public ArrayList<String> getListMonths() {
        return listMonths;
    }

    public void setListMonths(ArrayList<String> listMonths) {
        if (listMonths != null) {
            this.listMonths = listMonths;
        } else {
            throw new RuntimeException("List cannot be null");
        }
    }

    public void printMonths(String month) {
        //listMonths = null;
        month = "Jenuary";
        if (listMonths.contains(month)) {
            switch (month) {
                case "January":
                case "February":
                case "December":
                    System.out.println("Winter");
                    break;
                case "March":
                case "April":
                case "May":
                    System.out.println("Spring");
                    break;
                case "June":
                case "July":
                case "August":
                    System.out.println("Summer");
                    break;
                case "September":
                case "October":
                case "November":
                    System.out.println("Autumn");
                    break;
            }
        } else {
            throw new RuntimeException(String.format("Incorrect month name '%s'. Please try again!", month));
        }
    }
}