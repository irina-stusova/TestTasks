package com.penske.lessons.lesson5;

import java.util.ArrayList;

public class UniversityEnum {
    private String universityEnumName;
    private ArrayList<StudentEnum> studentsList5;

    public String getUniversityEnumName() {
        return universityEnumName;
    }

    public void setUniversityEnumName(String universityEnumName) {
        this.universityEnumName = universityEnumName;
    }

    public ArrayList<StudentEnum> getStudentsEnumList() {
        return studentsList5;
    }

    public void setStudentsEnumList(ArrayList<StudentEnum> studentsList5) {
        this.studentsList5 = studentsList5;
    }

    @Override
    public String toString() {
        return "University: " + this.universityEnumName + ": " + this.studentsList5;
    }

    public enum Faculties {
        AUTOMATION,
        INFORMATICS,
        CONSTRUCTION,
        LINGUISTIC,
        MARKETING;
    };

    public enum Courses {
        METROLOGY("Метрология"),
        QUALITY_MANAGEMENT("Управление качеством"),
        PUBLIC_RELATIONS("Связи с общественностью"),
        ENGLISH("Английский"),
        PORTUGUES("Любимый Португальский"),
        REAL_ESTATE_ESTIMATION("Оценка недвижимости"),
        ENGINEERING("Инженерия");

        private final String courseDescription;
        Courses (String courseDescription) {
            this.courseDescription = courseDescription;
        }

//        @Override
//        public String toString() {return courseDescription;}
    };

    public enum Groups {
        GROUP1("Группа А", 11L),
        GROUP2("Группа Б", 12L),
        GROUP3("Группа В", 13L),
        GROUP4("Группа Г", 14L),
        GROUP5("Группа Д", 15L),
        GROUP6("Группа Е", 16L);


        private final String groupDescription;
        private final Long groupId;
        Groups (String groupDescription, Long groupId) {
            this.groupDescription = groupDescription;
            this.groupId = groupId;
        }

        @Override
        public String toString() {return groupDescription;}

//        public void setGroupDescription(String groupDescription) {
//            this.groupDescription = groupDescription;
//        }
//
//        public String getGroupDescription() {
//            return groupDescription;
//        }

//        public void setGroupId(Long groupId) {
//            this.groupId = groupId;
//        }
//
//        public Long getGroupId() {
//            return groupId;
//        }
    }


    // метод для получения списка студентов заданного факультета

    public ArrayList<StudentEnum> getStudentsListForFaculty(Faculties faculty) {
        ArrayList<StudentEnum> lOut = new ArrayList();
        for (StudentEnum student : studentsList5) {
            if (student.getFaculty().equals(faculty)) {
                lOut.add(student);
            }
        }
        return lOut;
    }

// метод для получения списка студентов заданного курса

    public ArrayList<StudentEnum> getStudentsListForCourse(Courses course) {
        ArrayList<StudentEnum> lOut = new ArrayList();
        for (StudentEnum student : studentsList5) {
            if (student.getCourse().equals(course)) {
                lOut.add(student);
            }
        }
        return lOut;
    }


// метод для получения списка учебной группы

    public ArrayList<StudentEnum> getStudentsListForGroup(Groups group) {
        ArrayList<StudentEnum> lOut = new ArrayList();
        for (StudentEnum student : studentsList5) {
            if (student.getGroup().equals(group)) {
                lOut.add(student);
            }
        }
        return lOut;
    }


    public void printList(ArrayList<StudentEnum> list) {
        for (StudentEnum student : list) {
            System.out.println(student);
        }
    }
}


