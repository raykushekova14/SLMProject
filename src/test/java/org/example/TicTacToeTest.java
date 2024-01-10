package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testSwitchPlayer() {
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');

        game.switchPlayer();
        Assertions.assertEquals(player2, game.getCurrentPlayer());

        game.switchPlayer();
        Assertions.assertEquals(player1, game.getCurrentPlayer());
    }

    @Test
    public void testHasWon() {
        Board board = new Board();
        board.initialize();
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'X');
        board.makeMove(2, 2, 'X');
        Assertions.assertTrue(board.hasWon('X'));
    }
}




