package net.oswin.exercises.homework.tictactoe;

/**
 * Игра крестики-нолики.
 *    0 1 2
 * 0  x o x
 * 1  x o o
 * 2  x x o
 */
public class TicTacToe {
    private char[][] ttt = new char[3][3];
    private byte prev = 0;
    private int k = 0;

    public TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ttt[i][j] = ' ';
            }
        }
    }

    /**
     * Ход
     * @param x
     * @param y
     */
    public void turn(int x, int y, byte player) {
        char xo = ' ';
        if (player == 1) {
            xo = 'X';
        } else {
           xo = 'O';
        }
        if ((prev != (player)) && (ttt[x - 1][y - 1] == ' ')) {
            ttt[x - 1][y - 1] = xo;
        } else {
            throw new IllegalArgumentException();
        }
        k++;
        prev = player;
    }

    /**
     * Определяет победу Х или О.
     * @return Возвращает true в случае победы, false - в других случаях
     */
    public char whoIsWin(byte player, int[] victories) {
        /**if (isWin(player) && (player == 1)) {
            return 'X';
        } else if (isWin(player) && (player == 0)) {
            return 'O';
        }
         */
        if (isWin(player)) {
            victories[player]++;
            if (player == 1) {
                return 'X';
            } else return 'O';
        }
        return ' ';
    }


    public boolean isWin(byte player) {
        char pl = ' ';
        if (player == 1) {
            pl = 'X';
        } else {
            pl = 'O';
        }
        int h = 0;
        int v = 0;
        int md = 0;
        int sd = 0;
        for (int i = 0; i < 3; i++) {
            h = 0;
            v = 0;
            for (int j = 0; j < 3; j++) {
                if ((i == j) && (ttt[i][j] == pl)) md++;
                if ((i + j == 2) && (ttt[i][j] == pl)) sd++;
                if (ttt[i][j] == pl) h++;
                if (ttt[j][i] == pl) v++;
            }
            if (h == 3 || v == 3 || md == 3 || sd == 3)
                return true;

        }
        return false;
    }

    public char whoIsPlay() {
        char who = ' ';
        if (prev == 0) {
            who = 'X';
        } else {
            who = 'O';
        }
        return who;
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
        if (k == 9) {
            return true;
        }
        return false;
    }

}