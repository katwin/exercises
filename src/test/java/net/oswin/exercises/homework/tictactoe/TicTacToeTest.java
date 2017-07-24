package net.oswin.exercises.homework.tictactoe;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kate on 19.07.2017.
 */
public class TicTacToeTest {
    @Test
    public void test() {
        TicTacToe tictactoe = new TicTacToe();
        Assert.assertEquals('X', tictactoe.whoIsPlay());
        tictactoe.turn(1,1);
        Assert.assertTrue(!tictactoe.isWin((byte) 1));
        Assert.assertEquals('O', tictactoe.whoIsPlay());
        tictactoe.turn(2,1);
        tictactoe.turn(1,2);
        tictactoe.turn(2,2);
        tictactoe.turn(1,3);
        //todo проверить варианты победы Х по вертикали, главной и побочной диагонали.
        Assert.assertTrue(tictactoe.whoIsWin() == 'X');
        tictactoe = new TicTacToe();
        tictactoe.turn(2,1);
        tictactoe.turn(1,1);
        tictactoe.turn(2,3);
        tictactoe.turn(2,2);
        tictactoe.turn(3,1);
        tictactoe.turn(3,3);
        //todo проверить варианты победы О по вертикали, горизонтали и побочной диагонали.
        Assert.assertTrue(tictactoe.whoIsWin() == 'O');
    }

    @Test
    public void testDraw() {
        TicTacToe tictactoe;
        tictactoe = new TicTacToe();
        tictactoe.turn(1,1);
        tictactoe.turn(1,3);
        tictactoe.turn(1,2);
        tictactoe.turn(2,1);
        Assert.assertFalse(tictactoe.isDraw());
        tictactoe.turn(2,3);
        tictactoe.turn(2,2);
        tictactoe.turn(3,1);
        tictactoe.turn(3,3);
        tictactoe.turn(3,2);
        tictactoe.whoIsWin();
        Assert.assertTrue(tictactoe.isDraw());
    }

    @Test
    public void testToString() {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.turn(1,1);
        tictactoe.turn(2,2);
        tictactoe.turn(3,3);
        Assert.assertEquals(
                "X     \n" +
                "  O   \n" +
                "    X \n", tictactoe.toString());
    }
}
