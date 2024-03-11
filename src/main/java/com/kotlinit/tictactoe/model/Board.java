package com.kotlinit.tictactoe.model;

public class Board {
    private static final int SIZE = 3; // The size of the game board (3x3).

    private String[][] board; // The game board represented as a 2D array.
    private String currentPlayer; // The current player's symbol ('X' or 'O').

    /**
     * Constructs a new Board object and initializes the game board.
     */
    public Board() {
        initBoard();
        currentPlayer = "X"; // The game starts with player 'X'.
    }

    /**
     * Initializes the game board with the default state (all cells empty).
     */
    private void initBoard() {
        board = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = "_"; // Empty cells are represented by underscores.
            }
        }
    }

    /**
     * Makes a move on the board by placing the current player's symbol at the specified row and column.
     *
     * @param row The row index (0-based).
     * @param col The column index (0-based).
     */
    public void makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer;
            currentPlayer = currentPlayer.equals("X") ? "O" : "X"; // Switch to the next player.
        }
    }

    /**
     * Checks if the specified move is valid (within the board bounds and the cell is empty).
     *
     * @param row The row index.
     * @param col The column index.
     * @return true if the move is valid, false otherwise.
     */
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col].equals("_");
    }

    /**
     * Checks if the game is over (a player has won, or it's a draw).
     *
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return isWinner("X") || isWinner("O") || isDraw();
    }

    /**
     * Checks if the specified player has won the game.
     *
     * @param player The player's symbol ('X' or 'O').
     * @return true if the player has won, false otherwise.
     */
    private boolean isWinner(String player) {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        return board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player);
    }

    /**
     * Checks if the game is a draw (no more empty cells and no winner).
     *
     * @return true if the game is a draw, false otherwise.
     */
    private boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the current state of the game board.
     *
     * @return A 2D array representing the game board.
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     * Returns the current state of the game as a string.
     *
     * @return A string representing the game state ("X wins", "O wins", "Draw", or "Game not finished").
     */
    public String getGameState() {
        if (isWinner("X")) {
            return "X wins";
        } else if (isWinner("O")) {
            return "O wins";
        } else if (isDraw()) {
            return "Draw";
        } else {
            return "Game not finished";
        }
    }
}