package com.company;

import com.company.Cabinet;
import com.company.utils.Student;
import com.company.utils.Type;

public class Robot implements Runnable {

    private int HOW_MANY_WORKS_CAN_HANDLE = 5;
    private Cabinet cabinet;
    private Type type;

    public Robot(Cabinet cabinet, Type type) {
        this.cabinet = cabinet;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("ROBOT_OF_" + type);

                Thread.sleep(1000);
                Student student = cabinet.get(type);

                //checking...
                if (student != null) {
                    while (student.checkProgress()) {
                        Thread.sleep(1000);
                        student.increaseCheckingProgress(HOW_MANY_WORKS_CAN_HANDLE);
                        //System.out.println(student.getCheckingProgress() + "/" + student.getLoad()
                        //    + " has been checked by " + Thread.currentThread().getName());
                    }
                }
            } catch (InterruptedException error) {
                error.printStackTrace();
            }

        }
    }
}
