package net.oswin.exercises.oop;

/**
 * Created by Kate on 17.04.2017.
 */
public class MarsRoverControl {
    public static void main(String[] args) {
        MarsRover curiosity = new MarsRover(0, 0);
        curiosity.goForward(7);
        curiosity.turnLeft(90);
        curiosity.goBack(4);
        curiosity.turnRight(90);
        curiosity.goForward(3);
        curiosity.turnRight(90);
        curiosity.goForward(6);
        System.out.println("Curiosity's location is " + curiosity.getLocationX() + "," + curiosity.getLocationY());

        MarsRover opportunity = new MarsRover(0, 0, 0);
        opportunity.goForward(10);
        opportunity.turnLeft(90);
        opportunity.goForward(10);
        System.out.println("Opportunity's location is " + opportunity.getLocationX() + "," + opportunity.getLocationY());
    }
}
