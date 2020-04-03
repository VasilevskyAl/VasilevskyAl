package com.company;

import com.company.utils.Student;
import com.company.utils.Type;
import java.util.ArrayList;
import java.util.List;

public class Cabinet {

    private int MAX_CABINET_CAPACITY = 5;
    private int MIN_CABINET_CAPACITY = 0;
    private List<Student> list;
    private int studentsCount;

    public Cabinet() {
        list = new ArrayList<>();
    }

    public synchronized void add(Student student) {
        try {
            if (studentsCount < MAX_CABINET_CAPACITY) {
                notifyAll();

                list.add(student);

                System.out.println("Current: " + list.size() + " | Student went into the cabinet... " +
                        Thread.currentThread().getName() + "\t\t" + student.getLoad() + "\t\t" + student.getType());
                studentsCount++;
            } else {
                System.out.println("Current: " + list.size() + " | Cabinet is full. Wait your turn! "
                        + Thread.currentThread().getName());
                wait();
            }
        } catch(InterruptedException error) {
            error.printStackTrace();
        }
    }

    public synchronized Student get(Type studentType) {
        try {
            if (studentsCount > MIN_CABINET_CAPACITY) {
                notifyAll();

                for (Student student : list) {

                    if (studentType == student.getType()) {
                        studentsCount--;

                        System.out.println("Current: " + list.size() + " | Student left the cabinet... " +
                                Thread.currentThread().getName() + "\t\t" + student.getLoad() + "\t\t" + student.getType());

                        list.remove(student);
                        return student;
                    }
                }
            } else System.out.println(Thread.currentThread().getName() + " has invited a student, but there was nobody!");
            wait();

        } catch(InterruptedException error) {
            error.printStackTrace();
        }

        return null;
    }
}
