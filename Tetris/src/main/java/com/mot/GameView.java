package com.mot;

import static com.mot.Constants.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameView extends JFrame{

    JPanel cardPanel;
    GamePanel gamePanel;
    PausePanel pausePanel;
    Timer timer;
    SwitchKeyListener pauseAdapter;
    boolean pause = false;
    

    GameView () {
        super("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        pauseAdapter = new SwitchKeyListener();
    }

    public void start(GameModel model) {
        cardPanel = new JPanel(new CardLayout());
        createGamePanel(model);
        createPausePanel();
        add(cardPanel);
        setVisible(true);
    }

    public void createGamePanel(GameModel model) {
        gamePanel = new GamePanel(model, pauseAdapter);
        timer = new Timer(DELAY, gamePanel);
        timer.start();
        cardPanel.add(gamePanel, GAME);
    }

    public void createPausePanel() {
        JButton buttonToGame = new ButtonToGame("Continue");
        JButton buttonToExit = new ButtonToExit("Exit");
        pausePanel = new PausePanel(buttonToGame, buttonToExit, pauseAdapter);
        cardPanel.add(pausePanel, PAUSE);
    }

    public class SwitchKeyListener extends KeyAdapter {

        @Override
        public synchronized void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_ESCAPE:
                    CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                    if (!pause) {
                        pause = true;
                        timer.stop();
                        cardLayout.show(cardPanel, PAUSE);
                        cardPanel.getComponent(1).requestFocusInWindow();
                        
                    }
                    else {
                        pause = false;
                        timer.start();
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
                    timer.start();
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
}
