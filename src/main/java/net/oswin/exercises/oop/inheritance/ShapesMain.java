package net.oswin.exercises.oop.inheritance;

/**
 * Работа с фигурами.
 */
public class ShapesMain {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 90);
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(5, 7);
        Square square = new Square(6);

        System.out.println("Треугольник:");
        System.out.println("S = " + triangle.getSquare());
        System.out.println("P = " + triangle.getPerimeter());

        System.out.println("Круг:");
        System.out.println("S = " + circle.getSquare());
        System.out.println("l = " + circle.getPerimeter());

        System.out.println("Прямоугольник:");
        System.out.println("S = " + rectangle.getSquare());
        System.out.println("P = " + rectangle.getPerimeter());

        System.out.println("Квадрат:");
        System.out.println("S = " + square.getSquare());
        System.out.println("P = " + square.getPerimeter());
    }
}
