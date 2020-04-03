package ru.spbstu.main.shapes;

public class Vector implements Point {
    public float x = 0;
    public float y = 0;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+ x + "; " + y + ")";
    }

    public static float getDistance(Vector a, Vector b) {
        return (float) (Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)));
    }
}
