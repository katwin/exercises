package net.oswin.exercises.homework.tictactoe;

/**
 * Created by Kate on 02.08.2017.
 */
public abstract class TicTacToeAI {
    protected TicTacToe tictactoe;

    public TicTacToeAI(TicTacToe tictactoe) {
        this.tictactoe = tictactoe;
    }

    public abstract int[] turnAI();
}
