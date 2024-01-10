package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public TicTacToe() {
        board = new Board();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        currentPlayer = player1;
        scanner = new Scanner(System.in);
    }

    public void start() {
        board.initialize();
        board.print();
        while (!board.isGameOver()) {
            System.out.println(currentPlayer.getName() + ", make your move (row[1-3] column[1-3]):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            if (board.isValidMove(row, col)) {
                board.makeMove(row, col, currentPlayer.getSymbol());
                board.print();
                if (board.hasWon(currentPlayer.getSymbol())) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                } else if (board.isDraw()) {
                    System.out.println("It's a draw!");
                    break;
                }
                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        System.out.println("Do you want to play again? (y/n)");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("y")) {
            start();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
