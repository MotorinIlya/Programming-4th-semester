package com.mot.model;

import com.mot.controller.GameController;
import com.mot.view.game.GameView;

public class Game {
    
    private GameModel gameModel;
    private GameView gameView;
    private GameController gameController;

    public Game() {
        gameController = new GameController();
        gameModel = new GameModel();
        gameView = new GameView(gameController);

        gameController.start(gameView, gameModel);
    }
}
