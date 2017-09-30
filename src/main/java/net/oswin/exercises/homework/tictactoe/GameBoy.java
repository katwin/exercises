package net.oswin.exercises.homework.tictactoe;

/**
 * Created by Kate on 12.07.2017.
 */
public class GameBoy {
    /**
     * Счетчик побед
     * [0]  победы нулевого игрока
     * [1]  победы первого игрока
     */
    private int[] victories = new int[2];
    private TicTacToe tictactoe;
    private TicTacToeAI ai;

    /**todo hw 10.08
     /DONE/
     Несколько режимов игры - mode:
     0-ч/ч
     1-ч/к
     2-к/к (пока не надо)

     /DONE/
     Добавить выбор mode в Main

     /DONE/
     whoPlayerTurnFirst - поле gameboy

     /DONE/
     Убрать victories, заменить на игр1/2

     /IN PROGRESS/
     Применить mode в startgame(case0/1)

     /IN PROGRESS/
     Поменять Main

     -Убрать ai в turn при mode=0

     -Дописать gameboy.next

     -whoPlayerTurnFirst в mode=0 выбирает игрока

     ! 0/1игрок присвоен изначально, далее решается, кто первый

     Сеттер задан для mode - ???
     В gameboy кто первый ходит (mode=1) решается сеттером - ???
     */

    private char zeroPlayerTurnFor;
    /**
     * Режим игры
     * 0 - человек с человеком
     * 1 - человек с компьютером (нулевой игрок - компьютер, первый игрок - человек)
     * 2 - компьютер с компьютером
     */
    private int mode = 0;

    /**
     * Кто ходит первым?
     * 0 - нулевой игрок
     * 1 - первый игрок
     */
    private int whoPlayerTurnFirst;

    public void startGame(TicTacToe tictactoe, String mode) {
        this.tictactoe = tictactoe;
        whoPlayerTurnFirst = ((int) ((Math.random()*100)))%2;
        switch (mode) {
            case "1": {
                if (whoPlayerTurnFirst == 0) {
                    zeroPlayerTurnFor = 'X';
                    int[] turn = ai.turnAI();
                    innerTurn(turn[0], turn[1]);
                } else {
                    zeroPlayerTurnFor = 'O';
                }
                break;
            }
            case "0": {
                //int[] turn =
                break;
            }
        }
    }

    public char getZeroTurn() {
        return zeroPlayerTurnFor;
    }

    public char whoPlay() {
        return tictactoe.whoIsPlay();
    }

    public void next() {
        ai.turnAI();
        //turn(x,y);
    }

    public void turn(int x, int y, String mode) {
        innerTurn(x, y);
        if (!isEnd()) {
            int[] turn = ai.turnAI();
            innerTurn(turn[0], turn[1]);
        }
    }

    private void innerTurn(int x, int y) {
        tictactoe.turn(x,y);
        char whowin = whoWin();
        if (whowin == zeroPlayerTurnFor) {
            victories[0]++;
        } else if (whowin != ' ') {
            victories[1]++;
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

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return tictactoe.toString();
    }
}
