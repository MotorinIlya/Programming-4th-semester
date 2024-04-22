package com.mot.view.game;

import javax.swing.*;

import com.mot.controller.GameController;
import com.mot.event.Event;
import com.mot.event.RestartEvent;
import com.mot.event.UpdatePositionEvent;
import com.mot.event.UpdateWatchEvent;
import com.mot.service.Observer;

import java.awt.*;
import static com.mot.Constants.*;

public class GamePanel extends JPanel implements Observer{
     
    GameController gameController;

    GamePanel(GameController gameController) {
        super();

        this.gameController = gameController;

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        
        addKeyListener(gameController);

        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        for (int i = 0; i < SCREEN_HEIGHT/BLOCK_SIZE; i++) {
            g.drawLine(0, i * BLOCK_SIZE, SCREEN_WIDTH, i * BLOCK_SIZE);
        }
        for (int i = 0; i < SCREEN_WIDTH/BLOCK_SIZE; i++) {
            g.drawLine(i * BLOCK_SIZE, 0, i * BLOCK_SIZE, SCREEN_HEIGHT);
        }
        
        drawField(g);
        drawFigure(g);
    }

    public void drawField(Graphics g) {
        g.setColor(Color.green);
        for (int i = 0; i < GAME_BLOCKS; i++) {
            if (gameController.getBlocks(i)) {
                g.fillRect(gameController.getX(i) * BLOCK_SIZE, 
                            gameController.getY(i) * BLOCK_SIZE, 
                            BLOCK_SIZE, 
                            BLOCK_SIZE);
            }
        }
    }

    public void drawFigure(Graphics g) {
        g.setColor(Color.red);
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            g.fillRect(gameController.getX(gameController.getBlock(i)) * BLOCK_SIZE, 
            gameController.getY(gameController.getBlock(i)) * BLOCK_SIZE, 
            BLOCK_SIZE, 
            BLOCK_SIZE);
        }
    }

    @Override
    public void update(Event event) {
        if (event instanceof UpdateWatchEvent) {
            repaint();
        }
        else if (event instanceof UpdatePositionEvent) {
            repaint();
        }
        else if (event instanceof RestartEvent) {
            repaint();
        }
    }
}
