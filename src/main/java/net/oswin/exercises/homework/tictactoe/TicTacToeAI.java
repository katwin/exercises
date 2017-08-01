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
     * Ход.
     * @return координаты ячейки.
     */
    public int[] turnAI() {
        int[] turn = attack();
        if (turn != null) {
            return turn;
        }
        turn = defence();
        if (turn != null) {
            return turn;
        }
        return turnRandom();
    }

    /**
     * Случайный ход. Используется в случае отсутствия атаки.
     * @return координаты ячейки.
     */
    private int[] turnRandom() {
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

    public int[] attack() {
        return get3rd(ticTacToe.whoIsPlay() == 'X' ? 'O' : 'X');
    }

    /**
     * Защитный ход. Выполняется в случае атаки.
     * @return координаты ячейки.
     */
    public int[] defence() {
        return get3rd(ticTacToe.whoIsPlay());
    }

    private int[] get3rd(char player1) {
        char opponent;
        char playerAI;
        if (player1 == 'O') {
            opponent = 'X';
            playerAI = 'O';
        } else {
            opponent = 'O';
            playerAI = 'X';
        }
        int h = 0;
        int[] hF = new int[2];
        int v = 0;
        int[] vF = new int[2];
        int md = 0;
        int[] mdF = new int[2];
        int sd = 0;
        int[] sdF = new int[2];
        char[][] ttt = ticTacToe.getTtt();
        for (int i = 0; i < 3; i++) {
            h = 0;
            v = 0;
            for (int j = 0; j < 3; j++) {
                if ((i == j) && (ttt[i][j] == opponent)) md++;
                if ((i == j) && (ttt[i][j] == playerAI)) md--;
                if ((i == j) && (ttt[i][j] == ' ')) {
                    mdF[0] = i;
                    mdF[1] = j;
                }
                if ((i + j == 2) && (ttt[i][j] == opponent)) sd++;
                if ((i + j == 2) && (ttt[i][j] == playerAI)) sd--;
                if ((i + j == 2) && (ttt[i][j] == ' ')) {
                    sdF[0] = i;
                    sdF[1] = j;
                }
                if (ttt[i][j] == opponent) h++;
                if (ttt[i][j] == playerAI) h--;
                if (ttt[i][j] == ' ') {
                    hF[0] = i;
                    hF[1] = j;
                }
                if (ttt[j][i] == opponent) v++;
                if (ttt[j][i] == playerAI) v--;
                if (ttt[j][i] == ' ') {
                    vF[0] = j;
                    vF[1] = i;
                }
            }
            if (h == 2 || v == 2 ) {
                if (h == 2)
                    return hF;
                if (v == 2)
                    return vF;
            }
        }
        if (md == 2 || sd == 2) {
            if (md == 2)
                return mdF;
            if (sd == 2)
                return sdF;
        }
        return null;
    }
}

/**    0 1 2
 *     X X O 0
 *     X . X 1
 *     . X X 2
 **/