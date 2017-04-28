package net.oswin.exercises.oop.inheritance;

/**
 * Треугольник
 */
public class Triangle extends Shape {
    private int side1;
    private int side2;
    private double angle;

    public Triangle(int side1, int side2, double angle) {
        this.side1 = side1;
        this.side2 = side2;
        this.angle = angle;
    }

    @Override
    public double getSquare() {
        return side1 * side2 * Math.sin(angle * Math.PI / 180) / 2;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2) - 2 * side1 * side2 * Math.cos(angle * Math.PI / 180));
    }
}
