package com.mot;

import javax.swing.*;

public class GameView extends JFrame{
    GameView (GameModel model) {
        add(new GamePanel(model));
        setTitle("Tetris");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
