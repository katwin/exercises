package net.oswin.exercises.homework.tictactoe;

/**
 * Created by Kate on 24.07.2017.
 */
public class GameRandomizer {
    public int random() {
        return random(3);
    }

    public int random(int limit) {
        return (int) (Math.random() * 100) % limit;
    }
}
