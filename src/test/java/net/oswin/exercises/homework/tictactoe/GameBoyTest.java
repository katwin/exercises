package net.oswin.exercises.homework.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Kate on 20.07.2017.
 */
public class GameBoyTest {
    @Test
    public void testWin() {
        GameBoy gameboy = new GameBoy();
        TicTacToeAI2 mockAI = mock(TicTacToeAI2.class);
        when(mockAI.turnAI()).thenReturn(new int[] {1,1});
        gameboy.setAi(mockAI);
        //начало игры
        TicTacToe mocks = mock(TicTacToe.class);
        gameboy.startGame(mocks);
        //кто ходит
        when(mocks.whoIsPlay()).thenReturn('T');
        assertEquals('T', gameboy.whoPlay());

        when(mocks.isWin((byte)1)).thenReturn(true);
        when(mocks.whoIsWin()).thenReturn('X');
        gameboy.turn(0,0);
        assertEquals(1, gameboy.getStatistics()[1]);

        when(mocks.isWin((byte)0)).thenReturn(true);
        when(mocks.whoIsWin()).thenReturn('O');
        gameboy.turn(0,0);
        assertEquals(1, gameboy.getStatistics()[0]);

        when(mocks.whoIsWin()).thenReturn(' ');
        gameboy.turn(0,0);
        assertEquals(1, gameboy.getStatistics()[0]);
        assertEquals(1, gameboy.getStatistics()[1]);

        when(mocks.whoIsWin()).thenReturn('X');
        gameboy.turn(0,0);
        gameboy.startGame(mocks);
        assertEquals(2, gameboy.getStatistics()[1]);

        when(mocks.whoIsWin()).thenReturn('O');
        gameboy.turn(0,0);
        gameboy.startGame(mocks);
        assertEquals(2, gameboy.getStatistics()[0]);

    }
}
