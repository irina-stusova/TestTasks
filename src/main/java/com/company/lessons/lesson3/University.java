package com.company.lessons.lesson3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class University {
    private String universityName;
    private ArrayList<Student> studentsList;

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "University: " + this.universityName + ": " + this.studentsList;
    }

    // метод для получения списка студентов заданного факультета

    public ArrayList<Student> getStudentsListForFaculty(String faculty) {
        ArrayList<Student> lOut = new ArrayList();
        for (Student student : studentsList) {
            if (student.getFaculty().equals(faculty)) {
                lOut.add(student);
            }
        }
        return lOut;
    }

// метод для получения списка студентов, родившихся после заданного года

    public ArrayList<Student> getStudentsBornAfterDate(Long birthDate) {
        ArrayList<Student> lOut = new ArrayList();
        for (Student student : studentsList) {
            if (student.getBirthDate() >= birthDate) {
                lOut.add(student);
            }
        }
        return lOut;
    }

// метод для получения списка учебной группы

    public ArrayList<Student> getStudentsListForGroup(String group) {
        ArrayList<Student> lOut = new ArrayList();
        for (Student student : studentsList) {
            if (student.getGroup().equals(group)) {
                lOut.add(student);
            }
        }
        return lOut;
    }


    public void printList(ArrayList<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }
}

