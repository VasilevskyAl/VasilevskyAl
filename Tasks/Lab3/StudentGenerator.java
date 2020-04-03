package com.company;

import com.company.Cabinet;
import com.company.utils.Student;
import com.company.utils.Type;
import java.util.Random;

public class StudentGenerator implements Runnable {

    private Cabinet cabinet;
    private int studentCount;

    public StudentGenerator(Cabinet cabinet, int studentCount) {
        this.cabinet = cabinet;
        this.studentCount = studentCount;
    }

    private int getRandomLoad() {
        int[] loadTypes = {10, 20, 100};
        Random random = new Random();
        return loadTypes[random.nextInt(loadTypes.length)];
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    @Override
    public void run() {
        int counter = 0;

        while (counter < studentCount) {
            Thread.currentThread().setName("Student_Generator " + counter);
            counter++;

            cabinet.add(new Student(getRandomLoad(), getRandomType()));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException error) {
                error.printStackTrace();
            }
        }
    }
}
