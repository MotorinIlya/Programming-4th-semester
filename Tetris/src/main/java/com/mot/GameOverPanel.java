package com.mot;

import javax.swing.*;
import java.awt.*;
import static com.mot.Constants.*;

public class GameOverPanel extends JPanel {

    GameModel model;

    GameOverPanel(GameModel model, JButton buttonToExit) {
        super();
        this.model = model;
        setBackground(Color.black);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        //addRestartButton(buttonToRestart);
        addExitMainButton(buttonToExit);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.setFont(new Font("GAME OVER", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics.stringWidth("GAME OVER")) / 2, SCREEN_HEIGHT / 3);
        g.setColor(Color.white);
        g.drawString("Score: " + model.getScore(), (SCREEN_WIDTH - metrics.stringWidth("Score: " + model.getScore())) / 2, 2 * SCREEN_HEIGHT / 3);
    }

    public void addRestartButton(JButton buttonToRestart) {
        buttonToRestart.setBackground(Color.yellow);
        add(buttonToRestart);
    }

    public void addExitMainButton(JButton buttonToExit) {
        buttonToExit.setBackground(Color.green);
        add(buttonToExit);
    } 
}
