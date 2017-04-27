package net.oswin.exercises.oop.inheritance;

/**
 * Треугольник
 */
public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double angle;

    public Triangle(double side1, double side2, double angle) {
        this.side1 = side1;
        this.side2 = side2;
        this.angle = angle;
    }
}
