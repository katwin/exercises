package net.oswin.exercises.oop;

/**
 * Марсоход
 */
public class MarsRover {

    //СВОЙСТВА
    private double x;
    private double y;
    private double angle = Math.PI;


    //КОНСТРУКТОР
    /**
     * Посадить марсоход на Марс
     */
    public MarsRover(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //МЕТОДЫ
    public void turnLeft(double angle) {
        this.angle = this.angle + angle;
    }

    public void turnRight(double angle) {
        this.angle = this.angle - angle;
    }

    public void goForward(double distance) {
        x = x + distance * Math.sin(angle);
        y = y - distance * Math.cos(angle);
    }

    public void goBack(double distance) {
        x = x - distance * Math.sin(angle);
        y = y + distance * Math.cos(angle);
    }

    public double getLocationX() {
         return x;
    }

    public double getLocationY() {
        return y;
    }
}
