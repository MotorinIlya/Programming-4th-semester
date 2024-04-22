package com.mot.view.game;

import javax.swing.*;

import com.mot.controller.GameController;
import com.mot.event.Event;
import com.mot.service.Observer;

import java.awt.*;
import static com.mot.Constants.*;

public class GameOverPanel extends JPanel implements Observer{

    GameController gameController;

    GameOverPanel(GameController gameController) {
        super();

        this.gameController = gameController;
        gameController.addObserver(this);

        setBackground(Color.black);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);

        //addRestartButton(buttonToRestart);
        addExitMainButton();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.setFont(new Font("GAME OVER", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics.stringWidth("GAME OVER")) / 2, 
                    SCREEN_HEIGHT / 3);
        g.setColor(Color.white);
        g.drawString("Score: " + gameController.getScore(), 
                    (SCREEN_WIDTH - metrics.stringWidth("Score: " + gameController.getScore())) / 2, 
                    2 * SCREEN_HEIGHT / 3);
    }

    /*public void addRestartButton(JButton buttonToRestart) {
        //buttonToRestart.setBackground(Color.yellow);
        //add(buttonToRestart);
    }*/

    public void addExitMainButton() {
        JButton buttonToExit = new JButton(BUTTON_EXIT);
        buttonToExit.addActionListener(gameController);
        buttonToExit.setBackground(Color.green);
        add(buttonToExit);
    }

    @Override
    public void update(Event event) {

    } 
}
