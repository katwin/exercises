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
        when(mocks.whoIsWin()).thenReturn(' ');
        gameboy.startGame(mocks);
        //кто ходит
        when(mocks.whoIsPlay()).thenReturn('T');
        assertEquals('T', gameboy.whoPlay());

        //победил Х
        when(mocks.isWin((byte)1)).thenReturn(true);
        when(mocks.isWin((byte)0)).thenReturn(false);
        when(mocks.whoIsWin()).thenReturn('X');
        gameboy.turn(0,0);
        if (gameboy.getZeroTurn() == 'X') {
            assertEquals(1, gameboy.getStatistics()[0]);
            assertEquals(0, gameboy.getStatistics()[1]);
        } else {
            assertEquals(1, gameboy.getStatistics()[1]);
            assertEquals(0, gameboy.getStatistics()[0]);
        }

        //победил О
        when(mocks.isWin((byte)0)).thenReturn(true);
        when(mocks.isWin((byte)1)).thenReturn(false);
        when(mocks.whoIsWin()).thenReturn('O');
        gameboy.turn(0,0);
        assertEquals(1, gameboy.getStatistics()[1]);
        assertEquals(1, gameboy.getStatistics()[0]);

        //никто не победил
        when(mocks.whoIsWin()).thenReturn(' ');
        when(mocks.isWin((byte)0)).thenReturn(false);
        when(mocks.isWin((byte)1)).thenReturn(false);
        when(mocks.isDraw()).thenReturn(true);
        gameboy.turn(0,0);
        assertEquals(1, gameboy.getStatistics()[0]);
        assertEquals(1, gameboy.getStatistics()[1]);

        //победил Х второй раз
        when(mocks.whoIsWin()).thenReturn('X');
        when(mocks.isWin((byte)1)).thenReturn(true);
        when(mocks.isWin((byte)0)).thenReturn(false);
        gameboy.turn(0,0);
        if (gameboy.getZeroTurn() == 'X') {
            assertEquals(2, gameboy.getStatistics()[0]);
            assertEquals(1, gameboy.getStatistics()[1]);
        } else {
            assertEquals(2, gameboy.getStatistics()[1]);
            assertEquals(1, gameboy.getStatistics()[0]);
        }

        //победил О второй раз
        when(mocks.whoIsWin()).thenReturn('O');
        when(mocks.isWin((byte)0)).thenReturn(true);
        when(mocks.isWin((byte)1)).thenReturn(false);
        gameboy.turn(0,0);
        assertEquals(2, gameboy.getStatistics()[1]);
        assertEquals(2, gameboy.getStatistics()[0]);
    }
}
