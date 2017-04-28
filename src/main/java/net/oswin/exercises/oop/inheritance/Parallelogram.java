package net.oswin.exercises.oop.inheritance;

/**
 *Параллелограмм
 */
public class Parallelogram extends Tetragon {
    private double angle;

    public Parallelogram(double side1, double side2, double angle) {
        super(side1, side2, side1, side2, angle, angle);
        this.angle = angle;
    }

    public double getSquare() {
        return side1 * side2 * Math.sin(angle * Math.PI / 180);
    }
}
