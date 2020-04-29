package com.company;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Robot extends Thread {
    private ConcurrentLinkedQueue<Student> studentQueue = new ConcurrentLinkedQueue<Student>();
    private String subject;
    private boolean active = true;

    static Semaphore semaphore;

    public Robot(String subject, ConcurrentLinkedQueue<Student> studentQueue, Semaphore semaphore) {
        this.subject = subject;
        this.studentQueue = studentQueue;
        Robot.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!studentQueue.isEmpty() && isInterrupted()) {
                    Robot newRobot = new Robot(subject, studentQueue, semaphore);
                    newRobot.start();
                }

                if (!isInterrupted() && studentQueue.element().subjectName.equals(subject) && active) {
                    semaphore.acquire();
                    System.out.println("Check " + studentQueue.remove().toString());

                    semaphore.release();
                    System.out.println("Labs in " + subject + " checked");
                    active = false;
                }
            }

            catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            catch (NoSuchElementException exception) {
                interrupt();
            }
        }
    }
}
