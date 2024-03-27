package com.mot;

import java.awt.CardLayout;

import javax.swing.*;

public class GameView extends JFrame{

    JPanel cardPanel;

    GameView (GameModel model) {
        cardPanel = new JPanel(new CardLayout());
        add(new GamePanel(model));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*public void start() {
        createGamePanel(model);
        createPausePanel();
        createGameOverPanel();
        setVisible(true);
    }*/
}
