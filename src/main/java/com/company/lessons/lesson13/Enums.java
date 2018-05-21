package com.company.lessons.lesson13;

public class Enums {
    public enum WeekDays {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;
    }

    public static void printEnum(WeekDays enumValue) {
        switch (enumValue) {
            case MONDAY:
                System.out.println("Enum Value is MONDAY");
                break;
            case TUESDAY:
                System.out.println("Enum Value is TUESDAY");
                break;
            case WEDNESDAY:
                System.out.println("Enum Value is WEDNESDAY");
                break;
            case THURSDAY:
                System.out.println("Enum Value is THURSDAY");
                break;
            case FRIDAY:
                System.out.println("Enum Value is FRIDAY");
                break;
            case SATURDAY:
                System.out.println("Enum Value is SATURDAY");
                break;
            case SUNDAY:
                System.out.println("Enum Value is SUNDAY");
                break;
        }
    }
}