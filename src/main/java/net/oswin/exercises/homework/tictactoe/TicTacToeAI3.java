package net.oswin.exercises.homework.tictactoe;

/**
 * Created by Kate on 02.08.2017.
 */
public class TicTacToeAI3 extends TicTacToeAI2 {
    public TicTacToeAI3(TicTacToe tictactoe, GameRandomizer randomizer) {
        super(tictactoe, randomizer);
    }

    @Override
    public int[] turnAI() {
        return super.turnAI();
    }

    @Override
    protected int[] turnRandom() {
        //3  1,1 ? 0,0 2,0 0,2 2,2 ?
        if (tictactoe.checkTurn(1, 1)) {
            return new int[]{1, 1};
        }
        int[][] freeCorners = new int[4][2];
        int free = 0;
        for (int i = 0; i < 3; i = i + 2) {
            for (int j = 0; j < 3; j = j + 2) {
                if (tictactoe.checkTurn(i, j)) {
                    freeCorners[free][0] = i;
                    freeCorners[free][1] = j;
                    free++;
                }
            }
        }
        if (free == 0) {
            return super.turnRandom();
        } else {
            return freeCorners[randomizer.random(free)];
        }
    }
}
