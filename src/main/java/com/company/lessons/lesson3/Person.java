package com.company.lessons.lesson3;

public class Person {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Long birthDate;
    private String address;
    private String phone;

    public Person(String firstName, String patronymic, String lastName, Long birthDate, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
    }

    public Person(){}
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString()
    {
        return "Person: "+this.firstName+" "+this.patronymic+" "+this.lastName+", birth date: "+this.birthDate+", address: "+this.address+", phone: "+this.phone;
    }
}

