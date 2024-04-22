package com.mot.view.game;

import static com.mot.Constants.*;
import java.awt.*;
import javax.swing.*;

import com.mot.controller.GameController;
import com.mot.event.*;
import com.mot.event.Event;
import com.mot.service.Observer;

public class GameView extends JFrame implements Observer {

    CardLayout cardLayout;
    JPanel cardPanel;

    GamePanel gamePanel;
    PausePanel pausePanel;
    GameOverPanel gameOverPanel;

    GameController gameController;
    

    public GameView (GameController gameController) {
        super("Tetris");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        this.gameController = gameController;
        gameController.addObserver(this);

        createGamePanel();
        createPausePanel();
        createGameOverPanel();
        add(cardPanel);
        setVisible(true);
    }

    public void createGamePanel() {
        gamePanel = new GamePanel(gameController);
        cardPanel.add(gamePanel, GAME);
        gameController.addObserver(gamePanel);
    }

    public void createPausePanel() {
        pausePanel = new PausePanel(gameController);
        cardPanel.add(pausePanel, PAUSE);
        gameController.addObserver(pausePanel);
    }

    public void createGameOverPanel() {
        gameOverPanel = new GameOverPanel(gameController);
        cardPanel.add(gameOverPanel, GAME_OVER);
        gameController.addObserver(gameOverPanel);
    }

    public void switchCardPanel(String namePanel) {
        cardLayout.show(cardPanel, namePanel);
    }

    @Override
    public void update(Event event) {
        if (event instanceof ToGameEvent) {
            cardLayout.show(cardPanel, GAME);
            gamePanel.requestFocusInWindow();
        }
        else if (event instanceof PauseEvent) {
            cardLayout.show(cardPanel, PAUSE);
            pausePanel.requestFocusInWindow();
        }
        else if (event instanceof GameOverEvent) {
            cardLayout.show(cardPanel, GAME_OVER);
            gameOverPanel.requestFocusInWindow();
        }
        else if (event instanceof RestartEvent) {
            cardLayout.show(cardPanel, GAME);
            gamePanel.requestFocusInWindow();
        }
    }
}