package net.oswin.exercises.homework.tictactoe;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Kate on 24.07.2017.
 */
public class TicTacToeAITest {
    @Test
    public void testTurnAI() {
        GameRandomizer mrandom = mock(GameRandomizer.class);
        TicTacToe mtictactoe = mock(TicTacToe.class);
        TicTacToeAI ai = new TicTacToeAI(mtictactoe, mrandom);

        char[][] ttt = fill(  "X  "
                            + "XX "
                            + "OO ");
        when(mtictactoe.whoIsPlay()).thenReturn('O');
        when(mtictactoe.getTtt()).thenReturn(ttt);
        int[] res = ai.turnAI();
        Assert.assertEquals(2, res[0]);
        Assert.assertEquals(2, res[1]);

        when(mtictactoe.checkTurn(1,2)).thenReturn(true);
        when(mrandom.random()).thenReturn(1,2);
        ttt = fill(   "X  "
                    + "O  "
                    + " X " );
        when(mtictactoe.whoIsPlay()).thenReturn('O');
        when(mtictactoe.getTtt()).thenReturn(ttt);
        res = ai.turnAI();
        Assert.assertEquals(1, res[0]);
        Assert.assertEquals(2, res[1]);
    }

    @Test
    public void testDefence() throws Exception {
        GameRandomizer mrandom = mock(GameRandomizer.class);
        TicTacToe mtictactoe = mock(TicTacToe.class);
        TicTacToeAI ai = new TicTacToeAI(mtictactoe, mrandom);

        char[][] ttt = fill(
                "XX "+
                "   "+
                " OO");
        when(mtictactoe.getTtt()).thenReturn(ttt);
        when(mtictactoe.whoIsPlay()).thenReturn('O');
        int[] res = ai.defence();
        Assert.assertEquals(0, res[0]);
        Assert.assertEquals(2, res[1]);
        when(mtictactoe.whoIsPlay()).thenReturn('X');
        res = ai.defence();
        Assert.assertEquals(2, res[0]);
        Assert.assertEquals(0, res[1]);

        ttt = fill(
                "X  "+
                "XO "+
                " O ");
        when(mtictactoe.getTtt()).thenReturn(ttt);
        when(mtictactoe.whoIsPlay()).thenReturn('O');
        res = ai.defence();
        Assert.assertEquals(2, res[0]);
        Assert.assertEquals(0, res[1]);
        when(mtictactoe.whoIsPlay()).thenReturn('X');
        res = ai.defence();
        Assert.assertEquals(0, res[0]);
        Assert.assertEquals(1, res[1]);

        ttt = fill(
                "X O"+
                "   "+
                "O X");
        when(mtictactoe.getTtt()).thenReturn(ttt);
        when(mtictactoe.whoIsPlay()).thenReturn('O');
        res = ai.defence();
        Assert.assertEquals(1, res[0]);
        Assert.assertEquals(1, res[1]);
        when(mtictactoe.whoIsPlay()).thenReturn('X');
        res = ai.defence();
        Assert.assertEquals(1, res[0]);
        Assert.assertEquals(1, res[1]);
    }

    private char[][] fill(String tttString) {
        char[] tttchar = tttString.toCharArray();
        char[][] ttt = new char[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ttt[i][j] = tttchar[k];
                k++;
            }
        }
        return ttt;
    }

    public void testAttack() {
        GameRandomizer mrandom = mock(GameRandomizer.class);
        TicTacToe mtictactoe = mock(TicTacToe.class);
        TicTacToeAI ai = new TicTacToeAI(mtictactoe, mrandom);

        char[][] ttt = fill(
                "XX "+
                "   "+
                " OO");
        when(mtictactoe.getTtt()).thenReturn(ttt);
        when(mtictactoe.whoIsPlay()).thenReturn('X');
        int[] res = ai.attack();
        Assert.assertEquals(0, res[0]);
        Assert.assertEquals(2, res[1]);
        when(mtictactoe.whoIsPlay()).thenReturn('O');
        res = ai.attack();
        Assert.assertEquals(2, res[0]);
        Assert.assertEquals(0, res[1]);

        ttt = fill(
                "X  "+
                "XO "+
                " O ");
        when(mtictactoe.getTtt()).thenReturn(ttt);
        when(mtictactoe.whoIsPlay()).thenReturn('X');
        res = ai.attack();
        Assert.assertEquals(2, res[0]);
        Assert.assertEquals(0, res[1]);
        when(mtictactoe.whoIsPlay()).thenReturn('O');
        res = ai.attack();
        Assert.assertEquals(0, res[0]);
        Assert.assertEquals(1, res[1]);

        ttt = fill(
                "X O"+
                "   "+
                "O X");
        when(mtictactoe.getTtt()).thenReturn(ttt);
        when(mtictactoe.whoIsPlay()).thenReturn('O');
        res = ai.attack();
        Assert.assertEquals(1, res[0]);
        Assert.assertEquals(1, res[1]);
        when(mtictactoe.whoIsPlay()).thenReturn('X');
        res = ai.attack();
        Assert.assertEquals(1, res[0]);
        Assert.assertEquals(1, res[1]);
    }
}
