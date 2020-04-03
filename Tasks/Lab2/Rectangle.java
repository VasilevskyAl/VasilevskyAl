package ru.spbstu.main.shapes;


/**
 * Представление о прямоугольнике.
 * <p>
 * Прямоугольник — четырехугольник, у которого все углы
 * прямые (равны 90 градусам).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Прямоугольник</a>
 */
public class Rectangle implements Shape, Polygon {
    private Vector topLeft;
    private float rotationAngle = 0;

    public Rectangle(Vector topLeft, float rotationAngle) {

        if(topLeft.x <= 0 || topLeft.y <= 0)
        {
            throw new IllegalArgumentException("Wrong initialization of circle! Width and height must be a positive number!");
        }

        this.topLeft = topLeft;
        this.rotationAngle = rotationAngle;
    }


    public Rectangle(float width, float height, float rotationAngle) {
        this(new Vector(width / 2, height / 2), rotationAngle);
    }

    @Override
    public float getPerimeter() {
        return topLeft.x * 4 + topLeft.y * 4;
    }

    @Override
    public float getArea() {
        return topLeft.x * topLeft.y * 4;
    }

    @Override
    public int getRotation() {
        return (int) rotationAngle;
    }

    @Override
    public String toString() {
        return "Rectangle: " + "width = " + (topLeft.x * 2) + ", height = " + (topLeft.y * 2) +
                ", rotation angle = " + getRotation() + ", area = " + getArea() + ", perimeter = " + getPerimeter();
    }

    /*
     * TODO: Реализовать класс 'Rectangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
