package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Main {
    private static ConcurrentLinkedQueue<Student> studentQueue = new ConcurrentLinkedQueue<Student>();
    private static StudentGenerator studentGenerator = new StudentGenerator();

    private static Semaphore semaphore = new Semaphore(1, true);

    private static Robot robot1 = new Robot("Mathematics", studentQueue, semaphore);
    private static Robot robot2 = new Robot("OOP", studentQueue, semaphore);
    private static Robot robot3 = new Robot("Physics", studentQueue, semaphore);

    public static void main(String[] args){
        studentGenerator.start();
        studentGenerator.setQueue(studentQueue);
        robot1.start();
        robot2.start();
        robot3.start();
    }
}
