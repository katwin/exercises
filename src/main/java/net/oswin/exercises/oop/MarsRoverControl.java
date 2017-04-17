package net.oswin.exercises.oop;

/**
 * Created by Kate on 17.04.2017.
 */
public class MarsRoverControl {
    public static void main(String[] args) {
        MarsRover curiosity = new MarsRover(0, 0);
        curiosity.goForward(7);
        curiosity.turnLeft(Math.PI/2);
        curiosity.goBack(4);
        curiosity.turnRight(Math.PI/2);
        curiosity.goForward(3);
        curiosity.turnRight(Math.PI/2);
        curiosity.goForward(6);
        System.out.println(curiosity.getLocationX() + "," + curiosity.getLocationY());
    }
}
