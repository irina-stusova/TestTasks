package com.penske.lessons.lesson2;

import java.util.ArrayList;

public class Company {
    private String companyName;
    private ArrayList<Person> personsList = new ArrayList<Person>() {
        {
            add(new Person("Kate", "Gryn"));
            add(new Person("Ira", "Stusova"));
            add(new Person("Andrey", "Marchenko"));
            add(new Person("Andrey", "Alekseev"));
            add(new Person("Mr", "Tester"));
        }
    };

    public ArrayList<Person> getPersonsList() {
        return personsList;
    }

    public void setPersonsList(ArrayList<Person> personsList) {
        this.personsList = personsList;
    }

    public void printCompanySize(ArrayList<Person> personsList) {
        System.out.println(String.format("There are %d employees in the penske", personsList.size()));
    }

    public boolean firstNameIsPresent(String firstName) {
        for (Person person : personsList) {
            if (person.getFirstName().equals(firstName)) {
                return true;
            }
        }
        return false;
    }

    public boolean lastNameIsPresent(String lastName) {
        for (Person person : personsList) {
            if (person.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}



