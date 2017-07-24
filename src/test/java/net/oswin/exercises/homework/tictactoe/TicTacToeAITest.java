package net.oswin.exercises.homework.tictactoe;

import org.junit.Assert;
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

        when(mrandom.random()).thenReturn(1,2);
        when(mtictactoe.checkTurn(1,2)).thenReturn(true);
        int[] xy = ai.turnAI();
        Assert.assertEquals(1, xy[0]);
        Assert.assertEquals(2, xy[1]);

        when(mrandom.random()).thenReturn(2,3,1,1);
        when(mtictactoe.checkTurn(2,3)).thenReturn(false);
        when(mtictactoe.checkTurn(1,1)).thenReturn(true);
        xy = ai.turnAI();
        Assert.assertEquals(1, xy[0]);
        Assert.assertEquals(1, xy[1]);
    }
}
