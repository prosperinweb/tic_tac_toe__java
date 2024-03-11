/**
 * The GameController class is responsible for handling user input, updating the game state, and controlling the game flow.
 */
package com.kotlinit.tictactoe.controller;

import com.kotlinit.tictactoe.model.Board;
import com.kotlinit.tictactoe.view.BoardView;

import java.util.Scanner;

public class GameController {
    private final Board board;
    private final BoardView view;
    private final Scanner scanner;

    /**
     * Constructs a new GameController object and initializes the Board, BoardView, and Scanner.
     */
    public GameController() {
        board = new Board();
        view = new BoardView();
        scanner = new Scanner(System.in);
    }

    /**
     * Starts the Tic Tac Toe game and manages the game loop.
     */
    public void start() {
        view.printBoard(board);
        while (!board.isGameOver()) {
            makeMove();
            String gameState = board.getGameState();
            view.printGameState(board, gameState);
        }
    }

    /**
     * Prompts the user for a move, validates the input, and updates the game board.
     */
    private void makeMove() {
        System.out.println("Enter the coordinates:");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;
        if (isValidCoordinates(row, col)) {
            board.makeMove(row, col);
        } else {
            System.out.println("Invalid coordinates, try again.");
            makeMove();
        }
    }

    /**
     * Checks if the given coordinates are valid (within the board bounds).
     *
     * @param row The row index.
     * @param col The column index.
     * @return true if the coordinates are valid, false otherwise.
     */
    private boolean isValidCoordinates(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
}