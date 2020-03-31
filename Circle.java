package ru.spbstu.main.shapes;

/**
 * Представление об окружности.
 * <p>
 * Окру́жность — замкнутая плоская кривая, которая состоит из
 * всех точек на плоскости, равноудалённых от заданной точки.
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9E%D0%BA%D1%80%D1%83%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C">Окружность</a>
 */
public class Circle implements Shape, Ellipse {

    float radius;

    public Circle(float radius) {
        if(radius <= 0)
        {
            throw new IllegalArgumentException("Wrong initialization of circle! Radius must be a positive number!");
        }
        this.radius = radius;
    }

    @Override
    public float getLength() {
        return (float) (2 * Math.PI * radius);
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public String toString() {
        return "Circle: " + "radius = " + radius + ", area = " + getArea() + ", length = " + getLength();
    }

    /*
     * TODO: Реализовать класс 'Circle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
