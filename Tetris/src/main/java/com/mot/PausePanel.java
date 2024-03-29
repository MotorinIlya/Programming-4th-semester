package com.mot;

import javax.swing.*;
import static com.mot.Constants.*;
import java.awt.*;
import java.awt.event.*;

public class PausePanel extends JPanel {

    PausePanel(JButton buttonToGame, JButton buttonToExit, KeyAdapter pauseAdapter) {
        super();
        setBackground(Color.black);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(pauseAdapter);
        addContinueButton(buttonToGame);
        addExitMainButton(buttonToExit);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("PAUSE", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.setColor(Color.white);
        g.drawString("PAUSE", (SCREEN_WIDTH - metrics.stringWidth("PAUSE")) / 2, SCREEN_HEIGHT / 3);
    }

    public void addContinueButton(JButton buttonToGame) {
        buttonToGame.setBackground(Color.yellow);
        add(buttonToGame);
    }

    public void addExitMainButton(JButton buttonToExit) {
        buttonToExit.setBackground(Color.green);
        add(buttonToExit);
    }
}
