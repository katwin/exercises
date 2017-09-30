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
        tictactoe.turn(0,0);
        Assert.assertTrue(!tictactoe.isWin((byte) 1));
        Assert.assertEquals('O', tictactoe.whoIsPlay());
        tictactoe.turn(1,0);
        tictactoe.turn(0,1);
        tictactoe.turn(1,1);
        tictactoe.turn(0,2);
        Assert.assertTrue(tictactoe.whoIsWin() == 'X');
        tictactoe = new TicTacToe();
        tictactoe.turn(1,0);
        tictactoe.turn(0,0);
        tictactoe.turn(1,2);
        tictactoe.turn(1,1);
        tictactoe.turn(2,0);
        tictactoe.turn(2,2);
        Assert.assertTrue(tictactoe.whoIsWin() == 'O');
    }

    @Test
    public void testDraw() {
        TicTacToe tictactoe;
        tictactoe = new TicTacToe();
        tictactoe.turn(0,0);
        tictactoe.turn(0,2);
        tictactoe.turn(0,1);
        tictactoe.turn(1,0);
        Assert.assertFalse(tictactoe.isDraw());
        tictactoe.turn(1,2);
        tictactoe.turn(1,1);
        tictactoe.turn(2,0);
        tictactoe.turn(2,2);
        tictactoe.turn(2,1);
        tictactoe.whoIsWin();
        Assert.assertTrue(tictactoe.isDraw());
    }

    @Test
    public void testToString() {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.turn(0,0);
        tictactoe.turn(1,1);
        tictactoe.turn(2,2);
        Assert.assertEquals(
                "X     \n" +
                "  O   \n" +
                "    X \n", tictactoe.toString());
    }
}
