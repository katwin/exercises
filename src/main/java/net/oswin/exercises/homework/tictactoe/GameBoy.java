package net.oswin.exercises.homework.tictactoe;

/**
 * Created by Kate on 12.07.2017.
 */
public class GameBoy {
    private int[] victories = new int[2];
    private TicTacToe tictactoe;
    private TicTacToeAI ai;

    public void startGame(TicTacToe tictactoe) {
        this.tictactoe = tictactoe;
        double whoFirst = (Math.random()*100)%2;
        if (whoFirst == 0) {
            int[] turn = ai.turnAI();
            innerTurn(turn[0], turn[1]);
        }
    }

    public char whoPlay() {
        return tictactoe.whoIsPlay();
    }

    public void turn(int x, int y) {
        innerTurn(x, y);
        if (!isEnd()) {
            int[] turn = ai.turnAI();
            innerTurn(turn[0], turn[1]);
        }
    }

    private void innerTurn(int x, int y) {
        tictactoe.turn(x,y);
        char whowin = whoWin();
        if (whowin == 'X') {
            victories[1]++;
        }
        if (whowin == 'O') {
            victories[0]++;
        }
    }

    public char whoWin() {
        return tictactoe.whoIsWin();
    }

    public boolean isEnd() {
        return tictactoe.isWin((byte)0) || tictactoe.isWin((byte)1) || tictactoe.isDraw();
    }

    public int[] getStatistics() {
        return victories;
    }

    public void setAi(TicTacToeAI ai) {
        this.ai = ai;
    }

    @Override
    public String toString() {
        return tictactoe.toString();
    }
}
