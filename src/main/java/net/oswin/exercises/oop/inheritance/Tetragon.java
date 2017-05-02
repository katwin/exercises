package net.oswin.exercises.oop.inheritance;

/**
 * Четырёхугольник
 */
public class Tetragon extends Shape {
    protected double side1;
    protected double side2;
    protected double side3;
    protected double side4;
    protected double angle12;
    protected double angle34;

    public Tetragon(double side1, double side2, double side3, double side4, double angle12, double angle34) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
        this.angle12 = angle12;
        this.angle34 = angle34;
    }

    public double getPerimeter() {
        return side1 + side2 + side3 + side4;
    }

    public double getSquare() {
        return (side1 * side2 * Math.sin(angle12 * Math.PI / 180) / 2 + (side3 * side4 * Math.sin(angle34 * Math.PI / 180)) / 2);
    }
}
