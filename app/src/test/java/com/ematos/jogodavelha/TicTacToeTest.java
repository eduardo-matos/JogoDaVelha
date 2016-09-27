package com.ematos.jogodavelha;

import org.junit.Test;
import static org.junit.Assert.*;


public class TicTacToeTest {
    @Test
    public void firstMoveIsX() throws Exception {
        TicTacToe t = new TicTacToe();
        assertEquals(t.getNextMove(), TicTacToe.Moves.X);
    }

    @Test
    public void changeNextMoveUponMove() throws Exception {
        TicTacToe t = new TicTacToe();

        assertEquals(t.getNextMove(), TicTacToe.Moves.X); t.move(0);
        assertEquals(t.getNextMove(), TicTacToe.Moves.O); t.move(1);
        assertEquals(t.getNextMove(), TicTacToe.Moves.X); t.move(2);
        assertEquals(t.getNextMove(), TicTacToe.Moves.O);
    }

    @Test(expected = SamePositionMoveException.class)
    public void throwsExceptionIfTryToMoveTwiceOnSamePosition() throws Exception {
        TicTacToe t = new TicTacToe();

        t.move(4);
        t.move(4);
    }

    @Test(expected = PositionBeyondBoundariesException.class)
    public void throwsExceptionIfTryToMoveAboveBoundaries() throws Exception {
        (new TicTacToe()).move(9);
    }

    @Test(expected = PositionBeyondBoundariesException.class)
    public void throwsExceptionIfTryToMoveBelowBoundaries() throws Exception {
        (new TicTacToe()).move(-1);
    }

    @Test
    public void returnsTrueifGameHasFinished() throws Exception {
        TicTacToe t = new TicTacToe();

        for (int i = 0; i < 9; i++) {
            assertFalse(t.hasFinished());
            t.move(i);
        }

        assertTrue(t.hasFinished());
    }

    @Test
    public void returnsTrueIfGameHasWinner() throws Exception {
        TicTacToe t = new TicTacToe();
        t.move(0);
        t.move(8);
        t.move(1);
        t.move(7);
        t.move(2); // X wins
        assertTrue(t.hasFinished());
    }

    @Test
    public void hasGameWinner() throws Exception {
        int[][] movesToWin = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        TicTacToe t;

        t = new TicTacToe();
        t.move(0); assertFalse(t.hasWinner());
        t.move(8); assertFalse(t.hasWinner());
        t.move(1); assertFalse(t.hasWinner());
        t.move(7); assertFalse(t.hasWinner());
        t.move(2); // X wins
        assertTrue(t.hasWinner());

        t = new TicTacToe();
        t.move(3); assertFalse(t.hasWinner());
        t.move(1); assertFalse(t.hasWinner());
        t.move(4); assertFalse(t.hasWinner());
        t.move(2); assertFalse(t.hasWinner());
        t.move(5); // X wins
        assertTrue(t.hasWinner());

        t = new TicTacToe();
        t.move(6); assertFalse(t.hasWinner());
        t.move(1); assertFalse(t.hasWinner());
        t.move(7); assertFalse(t.hasWinner());
        t.move(2); assertFalse(t.hasWinner());
        t.move(8); // X wins
        assertTrue(t.hasWinner());

        t = new TicTacToe();
        t.move(0); assertFalse(t.hasWinner());
        t.move(1); assertFalse(t.hasWinner());
        t.move(4); assertFalse(t.hasWinner());
        t.move(2); assertFalse(t.hasWinner());
        t.move(8); // X wins
        assertTrue(t.hasWinner());

        t = new TicTacToe();
        t.move(1); assertFalse(t.hasWinner());
        t.move(2); assertFalse(t.hasWinner());
        t.move(4); assertFalse(t.hasWinner());
        t.move(3); assertFalse(t.hasWinner());
        t.move(7); // X wins
        assertTrue(t.hasWinner());

        t = new TicTacToe();
        t.move(2); assertFalse(t.hasWinner());
        t.move(1); assertFalse(t.hasWinner());
        t.move(5); assertFalse(t.hasWinner());
        t.move(3); assertFalse(t.hasWinner());
        t.move(8); // X wins
        assertTrue(t.hasWinner());

        t = new TicTacToe();
        t.move(0); assertFalse(t.hasWinner());
        t.move(1); assertFalse(t.hasWinner());
        t.move(4); assertFalse(t.hasWinner());
        t.move(2); assertFalse(t.hasWinner());
        t.move(8); // X wins
        assertTrue(t.hasWinner());

        t = new TicTacToe();
        t.move(2); assertFalse(t.hasWinner());
        t.move(1); assertFalse(t.hasWinner());
        t.move(4); assertFalse(t.hasWinner());
        t.move(3); assertFalse(t.hasWinner());
        t.move(6); // X wins
        assertTrue(t.hasWinner());

        t = new TicTacToe();
        t.move(1); assertFalse(t.hasWinner());
        t.move(0); assertFalse(t.hasWinner());
        t.move(3); assertFalse(t.hasWinner());
        t.move(2); assertFalse(t.hasWinner());
        t.move(5); assertFalse(t.hasWinner());
        t.move(4); assertFalse(t.hasWinner());
        t.move(6); assertFalse(t.hasWinner());
        t.move(7); assertFalse(t.hasWinner());
        t.move(8); assertFalse(t.hasWinner());
    }

    @Test
    public void getsWinner() throws Exception {
        TicTacToe t;

        t = new TicTacToe();
        t.move(0);
        t.move(8);
        t.move(1);
        t.move(7);
        t.move(2); // X wins
        assertEquals(TicTacToe.Moves.X, t.getWinner());

        t = new TicTacToe();
        t.move(8);
        t.move(0);
        t.move(7);
        t.move(1);
        t.move(4);
        t.move(2); // O wins
        assertEquals(TicTacToe.Moves.O, t.getWinner());
    }

    @Test(expected = NoWinnerException.class)
    public void throwsExceptionIfThereIsNoWinner() throws Exception {
        TicTacToe t = new TicTacToe();
        t.getWinner();
    }

}