package com.mot;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import static com.mot.Constants.*;

public class GamePanel extends JPanel implements ActionListener{
     
    GameModel model;

    GamePanel(GameModel model, KeyAdapter pauseAdapter) {
        this.model = model;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(new GameKeyListener());
        addKeyListener(pauseAdapter);
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
            if (model.getBlocks(i)) {
                g.fillRect(model.getX(i) * BLOCK_SIZE, 
                            model.getY(i) * BLOCK_SIZE, 
                            BLOCK_SIZE, 
                            BLOCK_SIZE);
            }
        }
    }

    public void drawFigure(Graphics g) {
        g.setColor(Color.red);
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            g.fillRect(model.getX(model.getBlock(i)) * BLOCK_SIZE, 
            model.getY(model.getBlock(i)) * BLOCK_SIZE, 
            BLOCK_SIZE, 
            BLOCK_SIZE);
        }
    }

    public class GameKeyListener extends KeyAdapter {
        @Override
        public synchronized void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    model.shiftFigure(1);
                    break;
                case KeyEvent.VK_LEFT:
                    model.shiftFigure(-1);
                    break;
                case KeyEvent.VK_UP:
                    model.flip();
                    break;
                case KeyEvent.VK_DOWN:
                    model.move();
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.running) {
            model.move();
            repaint();
        }
    }
}
