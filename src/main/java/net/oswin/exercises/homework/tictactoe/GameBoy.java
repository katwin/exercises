package net.oswin.exercises.homework.tictactoe;

/**
 * Created by Kate on 12.07.2017.
 */
public class GameBoy {
    private int[] victories;
    private byte player = 1;

    public TicTacToe startGame() {
        return new TicTacToe();
    }

    public byte whoPlay() {
        return player;
    }

    public void turn(TicTacToe tictactoe, int x, int y) {
        tictactoe.turn(x,y,player);
        player = (byte)Math.abs(player - 1);
    }

    public char whoWin(TicTacToe tictactoe) {
        return tictactoe.whoIsWin(player, victories);
    }

    public boolean isEnd(TicTacToe tictactoe) {
        return tictactoe.isWin(player);
    }

    public int[] getStatistics() {
        return victories;
    }
}
