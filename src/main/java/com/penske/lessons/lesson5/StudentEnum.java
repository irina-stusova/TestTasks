package com.penske.lessons.lesson5;

public class StudentEnum extends PersonEnum {
    private Long id;
    private UniversityEnum.Faculties faculty;
    private UniversityEnum.Courses course;
    private UniversityEnum.Groups group;


    public StudentEnum(String firstName, String patronymic, String lastName, Long birthDate, String address, String phone, Long id, UniversityEnum.Faculties faculty, UniversityEnum.Courses course, UniversityEnum.Groups group) {

        super(firstName, lastName, patronymic, birthDate, address, phone);
        this.id = id;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public StudentEnum() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UniversityEnum.Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(UniversityEnum.Faculties faculty) {
        this.faculty = faculty;
    }

    public UniversityEnum.Courses getCourse() {
        return course;
    }

    public void setCourse(UniversityEnum.Courses course) {
        this.course = course;
    }

    public UniversityEnum.Groups getGroup() {
        return group;
    }

    public void setGroup(UniversityEnum.Groups group) {
        this.group = group;
    }

    //how to break the long line below???

    @Override
    public String toString() {
        return "Student: " + super.getFirstName() + " " + super.getPatronymic() + " " + super.getLastName() + ", birth date: " + super.getBirthDate() + ", address: " + super.getAddress() + ", phone: " + super.getPhone() + ", ID: " + id + ", faculty: " + faculty + ", course: " + course + ", group: " + group;
    }
}

