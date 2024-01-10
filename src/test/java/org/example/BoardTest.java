package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void testInitialize() {
        Board board = new Board();
        board.initialize();
        char[][] expectedBoard = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    public void testIsValidMove() {
        Board board = new Board();
        board.initialize();
        assertTrue(board.isValidMove(0, 0));
        assertTrue(board.isValidMove(1, 1));
        assertTrue(board.isValidMove(2, 2));
        assertFalse(board.isValidMove(-1, 0));
        assertFalse(board.isValidMove(0, -1));
        assertFalse(board.isValidMove(3, 0));
        assertFalse(board.isValidMove(0, 3));
        board.makeMove(0, 0, 'X');
        assertFalse(board.isValidMove(0, 0));
    }

    @Test
    public void testMakeMove() {
        Board board = new Board();
        board.initialize();
        board.makeMove(0, 0, 'X');
        assertEquals('X', board.getBoard()[0][0]);
        board.makeMove(1, 1, 'O');
        assertEquals('O', board.getBoard()[1][1]);
    }

    @Test
    public void testHasWon() {
        Board board = new Board();
        board.initialize();
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertTrue(board.hasWon('X'));
        board.initialize();
        board.makeMove(0, 0, 'O');
        board.makeMove(1, 1, 'O');
        board.makeMove(2, 2, 'O');
        assertTrue(board.hasWon('O'));
        board.initialize();
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'O');
        board.makeMove(2, 2, 'X');
        assertFalse(board.hasWon('X'));
    }

    @Test
    public void testIsDraw() {
        Board board = new Board();
        board.initialize();
        assertFalse(board.isDraw());
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'O');
        board.makeMove(1, 1, 'X');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'X');
        board.makeMove(2, 1, 'O');
        board.makeMove(2, 2, 'X');
        assertTrue(board.isDraw());
    }

    @Test
    public void testIsGameOver() {
        Board board = new Board();
        board.initialize();
        assertFalse(board.isGameOver());
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'O');
        board.makeMove(1, 1, 'X');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'X');
        board.makeMove(2, 1, 'O');
        assertFalse(board.isGameOver());
        board.makeMove(2, 2, 'X');
        assertTrue(board.isGameOver());
    }
}

