package com.mot.controller;

import javax.swing.*;

import com.mot.event.*;
import com.mot.model.GameModel;
import com.mot.service.Observable;
import com.mot.view.game.GameView;
import com.mot.view.menu.MainView;

import static com.mot.Constants.*;

import java.awt.event.*;

public class GameController extends Observable implements ActionListener, KeyListener{

    private GameModel gameModel;
    private GameView gameView;

    private Timer timer;

    public GameController() {
        timer = new Timer(DELAY, this);
    }

    public void start(GameView gameView, GameModel gameModel) {
        this.gameView = gameView;
        this.gameModel = gameModel;

        timer.start();
    }

    public Boolean getBlocks(int block) {
        return gameModel.getBlocks(block);
    }

    public Integer getX(int index) {
        return gameModel.getX(index);
    }

    public Integer getY(int index) {
        return gameModel.getY(index);
    }

    public Integer getBlock(int index) {
        return gameModel.getBlock(index);
    }

    public void move() {
        gameModel.move();
    }

    public int getScore() {
        return gameModel.getScore();
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd == BUTTON_TO_GAME) {
            gameModel.running = true;
            timer.start();
            update(new ToGameEvent());
        }
        else if (cmd == BUTTON_EXIT) {
            update(new ToExitEvent());
            gameView.dispose();
            new MainView();
        }
        else if (cmd == BUTTON_RESTART) {
            gameModel.restart();
            timer.start();
            update(new RestartEvent());

        }

        gameModel.move();
        update(new UpdateWatchEvent());

        if (gameModel.isGameOver()) {
            update(new GameOverEvent());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                gameModel.shiftFigure(1);
                update(new UpdatePositionEvent());
                break;
            case KeyEvent.VK_LEFT:
                gameModel.shiftFigure(-1);
                update(new UpdatePositionEvent());
                break;
            case KeyEvent.VK_UP:
                gameModel.flip();
                update(new UpdatePositionEvent());
                break;
            case KeyEvent.VK_DOWN:
                gameModel.move();
                update(new UpdatePositionEvent());
                break;
            case KeyEvent.VK_ESCAPE:
                if (gameModel.running) {
                    gameModel.running = false;
                    timer.stop();
                    update(new PauseEvent());
                }
                else {
                    gameModel.running = true;
                    timer.start();
                    update(new ToGameEvent());
                }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
