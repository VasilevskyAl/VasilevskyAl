package com.company;

import com.company.tasks.Robot;
import com.company.tasks.StudentGenerator;
import com.company.utils.Type;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        int studentCount = 100;

        Cabinet cabinet = new Cabinet();

        StudentGenerator studentGenerator = new StudentGenerator(cabinet, studentCount );

        Robot robot1 = new Robot(cabinet, Type.PHYSICS);
        Robot robot2 = new Robot(cabinet, Type.HIGHER_MATHEMATICS);
        Robot robot3 = new Robot(cabinet, Type.OOP);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(studentGenerator);

        service.execute(robot1);
        service.execute(robot2);
        service.execute(robot3);
    }
}
