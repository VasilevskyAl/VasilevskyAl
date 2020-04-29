package com.company;

public class Student {
    public String subjectName;
    public int number;
    public int tasksCount;


    Student(String subjectName, int number, int labsCount) {
        this.subjectName = subjectName;
        this.number = number;
        this.tasksCount = labsCount;
    }

    @Override
    public String toString() {
        String s = "Student " + number + ", who has " + tasksCount + " in " + subjectName;
        return s;
    }
}
