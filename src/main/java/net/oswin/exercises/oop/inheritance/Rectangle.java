package net.oswin.exercises.oop.inheritance;

/**
 * Прямоугольник
 */
public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        return height * width;
    }

    public double getPerimeter() {
        return 2 * (height + width);
    }
}
