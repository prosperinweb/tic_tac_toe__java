/**
 * The BoardView class is responsible for rendering the game board and displaying game state messages.
 */
package com.kotlinit.tictactoe.view;

import com.kotlinit.tictactoe.model.Board;

public class BoardView {
    private static final String BOARD_FORMAT = """
            ---------
            | %s %s %s |
            | %s %s %s |
            | %s %s %s |
            ---------""";

    /**
     * Prints the current state of the game board.
     *
     * @param board The Board object representing the game board.
     */
    public void printBoard(Board board) {
        String[][] boardState = board.getBoard();
        System.out.printf((BOARD_FORMAT) + "%n",
                boardState[0][0], boardState[0][1], boardState[0][2],
                boardState[1][0], boardState[1][1], boardState[1][2],
                boardState[2][0], boardState[2][1], boardState[2][2]
        );
    }

    /**
     * Prints the current game state along with the game board.
     *
     * @param board     The Board object representing the game board.
     * @param gameState The current game state (e.g., "X wins", "Draw", etc.).
     */
    public void printGameState(Board board, String gameState) {
        printBoard(board);
        System.out.println(gameState);
    }
}
