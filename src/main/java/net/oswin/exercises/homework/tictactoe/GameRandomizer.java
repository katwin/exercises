package net.oswin.exercises.homework.tictactoe;

/**
 * Created by Kate on 24.07.2017.
 */
public class GameRandomizer {
    public int random() {
        return (int) ((Math.random() * 100) % 3);
    }
}
