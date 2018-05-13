package com.company.lessons.lesson3;

public class Student extends Person {
    private Long id;
    private String faculty;
    private String course;
    private String group;


    public Student(String firstName, String patronymic, String lastName, Long birthDate, String address, String phone, Long id, String faculty, String course, String group) {

        super(firstName, lastName, patronymic, birthDate, address, phone);
        this.id = id;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public Student() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    //how to break the long line below???

    @Override
    public String toString() {
        return "Student: " + super.getFirstName() + " " + super.getPatronymic() + " " + super.getLastName() + ", birth date: " + super.getBirthDate() + ", address: " + super.getAddress() + ", phone: " + super.getPhone() + ", ID: " + id + ", faculty: " + faculty + ", course: " + course + ", group: " + group;
    }
}


