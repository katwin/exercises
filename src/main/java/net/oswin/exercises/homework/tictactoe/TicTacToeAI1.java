package net.oswin.exercises.homework.tictactoe;

/**
 * 1 уровень сложности игры "Крестики-нолики 3х3".
 */
public class TicTacToeAI1 extends TicTacToeAI {
    protected GameRandomizer randomizer;

    public TicTacToeAI1 (TicTacToe tictactoe, GameRandomizer randomizer) {
        super(tictactoe);
        this.randomizer = randomizer;
    }

    protected int[] turnRandom() {
        int[] xy = new int[2];
        int xr;
        int yr;
        do {
            xr = randomizer.random();
            yr = randomizer.random();
        } while (!tictactoe.checkTurn(xr, yr));
        xy[0] = xr;
        xy[1] = yr;
        return xy;
    }

    public int[] turnAI() {
        return turnRandom();
    }
}
