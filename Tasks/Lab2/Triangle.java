package ru.spbstu.main.shapes;

/**
 * Представление о треугольнике.
 * <p>
 * Треуго́льник (в евклидовом пространстве) — геометрическая
 * фигура, образованная тремя отрезками, которые соединяют
 * три точки, не лежащие на одной прямой. Указанные три
 * точки называются вершинами треугольника, а отрезки —
 * сторонами треугольника. Часть плоскости, ограниченная
 * сторонами, называется внутренностью треугольника: нередко
 * треугольник рассматривается вместе со своей внутренностью
 * (например, для определения понятия площади).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A2%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Треугольник</a>
 */
public class Triangle implements Shape, Polygon {
    private Vector vertex1, vertex2, vertex3;
    private float rotationAngle = 0;

    public Triangle(Vector vertex1, Vector vertex2, Vector vertex3, float rotationAngle) {
        this.rotationAngle = rotationAngle;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;

        if(getArea() <= 0)
        {
            throw new IllegalArgumentException("Wrong initialization of triangle!");
        }
    }

    @Override
    public float getPerimeter() {
        float firstSide = Vector.getDistance(vertex1, vertex2);
        float secondSide = Vector.getDistance(vertex2, vertex3);
        float thirdSide = Vector.getDistance(vertex1, vertex3);

        return (firstSide + secondSide + thirdSide);
    }

    @Override
    public float getArea() {
        float firstSide = Vector.getDistance(vertex1, vertex2);
        float secondSide = Vector.getDistance(vertex2, vertex3);
        float thirdSide = Vector.getDistance(vertex1, vertex3);
        float halfPerimeter = getPerimeter() / 2;

        return (float) Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) *
                (halfPerimeter - secondSide) * (halfPerimeter - thirdSide));
    }

    @Override
    public int getRotation() {
        return (int) rotationAngle;
    }

    @Override
    public String toString() {
        return "Triangle: first vertex = " + vertex1 + ", second vertex = " + vertex2 + ", vertex3 = " + vertex3 +
                ", rotation angle = " + getRotation() + ", area = " + getArea() + ", perimeter = " + getPerimeter();
    }

    /*
     * TODO: Реализовать класс 'Triangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
