package com.mot;

public class Game {
    private GameModel gameModel;
    private GameView gameView;

    public Game() {
        gameModel = new GameModel();
        gameView = new GameView(gameModel);
    }

    public void run() {

    }
}
