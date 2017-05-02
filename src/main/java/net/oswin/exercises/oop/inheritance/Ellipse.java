package net.oswin.exercises.oop.inheritance;

/**
 * Овал
 */
public abstract class Ellipse extends Shape {
    protected double width;
    protected double height;

    public Ellipse(double width, double height) {
        this.width = width;
        this.height = height;
    }
}
