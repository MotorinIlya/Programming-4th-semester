package com.mot.view.game;

import javax.swing.*;

import com.mot.controller.GameController;
import com.mot.event.Event;
import com.mot.service.Observer;

import static com.mot.Constants.*;
import java.awt.*;

public class PausePanel extends JPanel implements Observer {

    GameController gameController;

    PausePanel(GameController gameController) {
        super();

        this.gameController = gameController;
        gameController.addObserver(this);

        setBackground(Color.black);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);

        addKeyListener(gameController);
        addRestartButton();
        addContinueButton();
        addExitMainButton();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("PAUSE", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.setColor(Color.white);
        g.drawString("PAUSE", 
                    (SCREEN_WIDTH - metrics.stringWidth("PAUSE")) / 2, 
                    SCREEN_HEIGHT / 3);
    }

    public void addContinueButton() {
        JButton buttonToGame = new JButton(BUTTON_TO_GAME);
        buttonToGame.addActionListener(gameController);
        buttonToGame.setBackground(Color.yellow);
        add(buttonToGame);
    }

    public void addExitMainButton() {
        JButton buttonToExit = new JButton(BUTTON_EXIT);
        buttonToExit.addActionListener(gameController);
        buttonToExit.setBackground(Color.green);
        add(buttonToExit);
    }

    public void addRestartButton() {
        JButton restartButton = new JButton(BUTTON_RESTART);
        restartButton.addActionListener(gameController);
        restartButton.setBackground(Color.white);
        add(restartButton);
    }

    @Override
    public void update(Event event) {

    }
}
