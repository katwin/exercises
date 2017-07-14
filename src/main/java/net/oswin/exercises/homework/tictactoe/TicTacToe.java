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
    /**
     * Текущий игрок
     */
    private byte player = 1;

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
    public void turn(int x, int y) {
        char xo = ' ';
        xo = whoIsPlay();
        if ((ttt[x - 1][y - 1] == ' ')) {
            ttt[x - 1][y - 1] = xo;
        } else {
            throw new IllegalArgumentException();
        }
        player = (byte)Math.abs(player - 1);
    }

    /**
     * Определяет победу Х или О.
     * @return Возвращает true в случае победы, false - в других случаях
     */
    public char whoIsWin() {
        if (isWin((byte)1)) {
            return 'X';
        } else if (isWin((byte)0)) {
            return 'O';
        }
        return ' ';
    }

    /**
     * Проверяет, выиграл ли какой-нибудь игрок
     * @param player какой-нибудь игрок
     * @return true - выиграл, false - нет
     */
    public boolean isWin(byte player) {
        char pl = whoIsPlay(player);
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
        who = whoIsPlay(player);
        return who;
    }

    private char whoIsPlay(byte player) {
        char who;
        if (player == 1) {
            who = 'X';
        } else {
            who = 'O';
        }
        return who;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ttt[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
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

}