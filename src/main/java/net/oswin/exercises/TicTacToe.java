package net.oswin.exercises;

import java.util.Objects;

/**
 * Игра крестики-нолики.
 *    0 1 2
 * 0  x o x
 * 1  x o o
 * 2  x x o
 */
public class TicTacToe {
    private char[][] ttt = new char[3][3];
    private boolean gamepos = true;
    private int k = 0;

    public TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ttt[i][j] = ' ';
            }
        }
    }

    /**
     * Ход крестика
     * @param x
     * @param y
     */
    public void turnX(int x, int y) {
        if (gamepos && (ttt[x - 1][y - 1] == ' ')) {
            ttt[x - 1][y - 1] = 'X';
        } else {
            throw new IllegalArgumentException();
        }
        k++;
        gamepos = false;
    }

    /**
     * Ход нолика
     *
     * @param x
     * @param y
     */
    public void turnO(int x, int y) {
        if (!gamepos && (ttt[x - 1][y - 1] == ' ')) {
            ttt[x - 1][y - 1] = 'O';
        } else {
            throw new IllegalArgumentException();
        }
        gamepos = true;
    }

    /**
     * Определяет победу Х
     * @return Возвращает true в случае победы, false - в других случаях
     */
    public boolean isWinX() {
        return whoIsWin('X');
    }

    /**
     * Определяет победу О
     * @return Возвращает true в случае победы, false - в других случаях
     */
    public boolean isWinO() {
        return whoIsWin('O');
    }

    private boolean whoIsWin(char player) {
        int h = 0;
        int v = 0;
        int md = 0;
        int sd = 0;
        for (int i = 0; i < 3; i++) {
            h = 0;
            v = 0;
            for (int j = 0; j < 3; j++) {
                if ((i == j) && (ttt[i][j] == player)) md++;
                if ((i + j == 2) && (ttt[i][j] == player)) sd++;
                if (ttt[i][j] == player) h++;
                if (ttt[j][i] == player) v++;
            }
            if (h == 3 || v == 3 || md == 3 || sd == 3)
                return true;

        }
        return false;
    }


    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res += ttt[i][j] + " ";
            }
            res += "\n";
        }
        return res;
    }

    public boolean isDraw() {
        if (k == 5) {
            return true;
        }
        return false;
    }

}