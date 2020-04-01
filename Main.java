package ru.spbstu.main;

import ru.spbstu.main.shapes.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Shape[] shapes = new Shape[10];
        System.out.print("Now the array is filled with shapes...\n");

        for (int i = 0; i < shapes.length; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    shapes[i] = new Circle(random.nextInt(20) + 1);
                    break;
                case 1:
                    shapes[i] = new Rectangle(random.nextInt(20) + 1,
                            random.nextInt(20) + 1,
                            random.nextInt(20) + 1);
                    break;
                case 2:
                    shapes[i] = new Triangle(new Vector(random.nextInt(20), random.nextInt(20)),
                            new Vector(random.nextInt(20), random.nextInt(20)),
                            new Vector(random.nextInt(20), random.nextInt(20)),
                            random.nextInt());
                    break;
            }
        }

        for (int i = 0; i < shapes.length; i++) {
            System.out.println(i + 1 + ". " + shapes[i].toString());
        }

        Shape maxAreaShape = findShapeByMaxArea(shapes);
        System.out.println("Max area has the " + maxAreaShape.toString());

        /*
         * TODO: Выполнить действия над массивом 'shapes'
         *
         * 1. Проинициализировать переменную 'shapes' массивом
         *    содержащим 10 произвольных фигур. Массив должен
         *    содержать экземпляры классов Circle, Rectangle
         *    и Triangle.
         *
         * 2. Найти в массиве 'shapes' фигуру с максимальной
         *    площадью. Для поиска фигуры необходимо создать
         *    статический метод в текущем классе (Main).
         */
    }

    public static Shape findShapeByMaxArea(Shape[] shapes) {
        if (shapes.length == 0)
        {
            throw new IllegalArgumentException("Shape array is empty!");
        }

        Shape maxAreaShape = shapes[0];

        for (int i = 1; i < shapes.length; i++)
        {
            if (shapes[i].getArea() > maxAreaShape.getArea())
            {
                maxAreaShape = shapes[i];
            }
        }

        return maxAreaShape;
    }

}

