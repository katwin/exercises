package net.oswin.exercises.oop;

/**
 * Марсоход
 */
public class MarsRover {

    //СВОЙСТВА
    private double x;
    private double y;
    private double angle;
    private double rad;



    //КОНСТРУКТОР
    /**
     * Посадить марсоход на Марс
     */
    public MarsRover(double x, double y) {
        this(x, y, 90);
    }

    public MarsRover(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        calcRad();
    }

    //МЕТОДЫ
    public void turnLeft(double angle) {
        this.angle = this.angle + angle;
        calcRad();
    }

    public void turnRight(double angle) {
        this.angle = this.angle - angle;
        calcRad();
    }

    private void calcRad() {
        rad = angle * Math.PI / 180;
    }

    public void goForward(double distance) {
        x = x + distance * Math.sin(rad);
        y = y + distance * Math.cos(rad);
    }

    public void goBack(double distance) {
        x = x - distance * Math.sin(rad);
        y = y - distance * Math.cos(rad);
    }

    public double getLocationX() {
         return x;
    }

    public double getLocationY() {
        return y;
    }

    public String toString() {
        return getLocationX() + "," + getLocationY();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj.getClass() != this.getClass())
            return false;
        return getLocationX() == ((MarsRover)obj).getLocationX() && getLocationY() ==  ((MarsRover)obj).getLocationY();
    }
}
