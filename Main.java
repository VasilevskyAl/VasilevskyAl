package ru.spbstu.main;

import ru.spbstu.main.shapes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[10];
        System.out.print("Enter 10 shapes\n");
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < shapes.length; i++) {
            System.out.print("1 - Circle, 2 - Rectangle, 3 - Triangle. Enter type: ");
            int shapeType = in.nextByte();

            if ((shapeType > 3) || (shapeType < 1)) {
                throw new IllegalArgumentException("Wrong type of shape!");
            }

            switch (shapeType) {
                case 1:
                    System.out.print("Enter radius of circle: ");
                    float radius = in.nextFloat();
                    shapes[i] = new Circle(radius);
                    break;
                case 2:
                    System.out.print("Enter width of rectangle: ");
                    float width = in.nextFloat();
                    System.out.print("Enter height of rectangle: ");
                    float height = in.nextFloat();
                    System.out.print("Enter rotation angel of rectangle: ");
                    float rotationAngel = in.nextFloat();
                    shapes[i] = new Rectangle(width, height, rotationAngel);
                    break;
                case 3:
                    System.out.print("Enter coordinates of first vertex of triangle: ");
                    Vector firstSide = new Vector(in.nextFloat(), in.nextFloat());
                    System.out.print("Enter coordinates of second vertex of triangle: ");
                    Vector secondSide = new Vector(in.nextFloat(), in.nextFloat());
                    System.out.print("Enter coordinates of third vertex of triangle: ");
                    Vector thirdSide = new Vector(in.nextFloat(), in.nextFloat());
                    System.out.print("Enter rotation angel of triangle: ");
                    float rotationAngel2 = in.nextFloat();
                    shapes[i] = new Triangle(firstSide, secondSide, thirdSide, rotationAngel2);
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
