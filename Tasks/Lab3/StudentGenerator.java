package com.company;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.company.Robot.semaphore;

public class StudentGenerator extends Thread {
    private ConcurrentLinkedQueue<Student> studentQueue = new ConcurrentLinkedQueue<Student>();

    private static final String[] subjects = {"Mathematics", "OOP", "Physics"};
    private static final int[] tasks = {10, 20, 100};
    private static final int CABINET_CAPACITY = 10;

    public void setQueue(ConcurrentLinkedQueue<Student> studentQueue) {
        this.studentQueue = studentQueue;
    }

    @Override
    synchronized public void run() {
        int number = 1;

        while (true) {
            if (studentQueue.size() < CABINET_CAPACITY) {

                try {
                    semaphore.acquire();

                    int subjectName = new Random().nextInt(subjects.length);
                    int countTask = new Random().nextInt(tasks.length);
                    Student student = new Student(subjects[subjectName], number, tasks[countTask]);

                    studentQueue.add(student);
                    System.out.println("Generated Student " + number + ", who has " + student.tasksCount + " in " + student.subjectName);
                    number++;
                    semaphore.release();
                }

                catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
