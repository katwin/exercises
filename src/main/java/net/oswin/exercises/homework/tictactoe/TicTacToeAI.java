package net.oswin.exercises.homework.tictactoe;

/**
 * Created by Kate on 20.07.2017.
 */
public class TicTacToeAI {
    private TicTacToe ticTacToe;
    private GameRandomizer randomizer;

    public TicTacToeAI(TicTacToe tictactoe, GameRandomizer randomizer) {
        this.ticTacToe = tictactoe;
        this.randomizer = randomizer;
    }

    /**
     * Выдает ход за ИИ
     * @return массив, где 0 - x координата, 1 - y координата
     */
    public int[] turnAI() {
        int[] xy = new int[2];
        int xr;
        int yr;
        do {
            xr = randomizer.random();
            yr = randomizer.random();
        } while (!ticTacToe.checkTurn(xr, yr));
        xy[0] = xr;
        xy[1] = yr;
        return xy;
    }
}
