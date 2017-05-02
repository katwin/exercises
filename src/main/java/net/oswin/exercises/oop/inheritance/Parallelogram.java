package net.oswin.exercises.oop.inheritance;

/**
 *Параллелограмм
 */
public class Parallelogram extends Tetragon {

    public Parallelogram(double side1, double side2, double angle) {
        super(side1, side2, side1, side2, angle, angle);
    }

    public double getSquare() {
        return side1 * side2 * Math.sin(angle12 * Math.PI / 180);
    }
}
