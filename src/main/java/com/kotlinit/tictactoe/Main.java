package com.kotlinit.tictactoe;

import com.kotlinit.tictactoe.controller.GameController;

public class Main {
    /**
     * The main method creates an instance of the GameController and starts the game.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.start();
    }
}
