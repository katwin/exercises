package net.oswin.exercises.oop.inheritance;

/**
 * Круг
 */
public final class Circle extends Ellipse {

    public Circle(double radius) {
        super(radius, radius);
    }

    public double getRadius() {
        return width;
    }

    public double getSquare() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }
}
