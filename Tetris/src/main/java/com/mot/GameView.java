package com.mot;

import static com.mot.Constants.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameView extends JFrame implements ActionListener{

    JPanel cardPanel;
    GamePanel gamePanel;
    PausePanel pausePanel;
    GameOverPanel gameOverPanel;
    Timer timerGame;
    Timer timerOver;
    SwitchKeyListener pauseAdapter;
    boolean pause = false;
    GameModel model;
    

    GameView () {
        super("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        pauseAdapter = new SwitchKeyListener();
    }

    public void start(GameModel model) {
        this.model = model;
        cardPanel = new JPanel(new CardLayout());
        createGamePanel(model);
        createPausePanel();
        createGameOverPanel(model);
        add(cardPanel);
        setVisible(true);
    }

    public void createGamePanel(GameModel model) {
        gamePanel = new GamePanel(model, pauseAdapter);
        timerGame = new Timer(DELAY, gamePanel);
        timerGame.start();

        timerOver = new Timer(DELAY, this);
        timerOver.start();
        
        cardPanel.add(gamePanel, GAME);
    }

    public void createPausePanel() {
        JButton buttonToGame = new ButtonToGame("Continue");
        JButton buttonToExit = new ButtonToExit("Exit");
        pausePanel = new PausePanel(buttonToGame, buttonToExit, pauseAdapter);
        cardPanel.add(pausePanel, PAUSE);
    }

    public void createGameOverPanel(GameModel model) {
        JButton buttonToExit = new ButtonToExit("Exit");
        //JButton buttonToRestart = new ButtonToRestart("Restart");
        gameOverPanel = new GameOverPanel(model, buttonToExit);
        cardPanel.add(gameOverPanel, GAME_OVER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!model.running) {
            timerGame.stop();
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.show(cardPanel, GAME_OVER);
        }
    } 

    public class SwitchKeyListener extends KeyAdapter {
        @Override
        public synchronized void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_ESCAPE:
                    CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                    if (!pause) {
                        pause = true;
                        timerGame.stop();
                        cardLayout.show(cardPanel, PAUSE);
                        cardPanel.getComponent(1).requestFocusInWindow();
                        
                    }
                    else {
                        pause = false;
                        timerGame.start();
                        cardLayout.show(cardPanel, GAME);
                        cardPanel.getComponent(0).requestFocusInWindow();
                    }
                    break;
            }
        }
    }

    public class ButtonToGame extends JButton {
        ButtonToGame(String name) {
            super(name);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                    pause = false;
                    timerGame.start();
                    cardLayout.show(cardPanel, GAME);
                    cardPanel.getComponent(0).requestFocusInWindow();
                }
            });
        }
    }

    public class ButtonToExit extends JButton {
        ButtonToExit(String name) {
            super(name);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    MainPanel m = new MainPanel();
                    m.start();
                }
            });
        }
    }

    /*public class ButtonToRestart extends JButton {

        GameModel model;
        
        ButtonToRestart(String name, GameModel model) {
            super(name);
            this.model = model;
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.restart();
                }
            });
        }
    }*/
}
