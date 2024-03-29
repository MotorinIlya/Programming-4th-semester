package com.mot;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import static com.mot.Constants.*;

public class GamePanel extends JPanel implements ActionListener{
     
    GameModel model;
    Timer timer;
    boolean pause;

    GamePanel(GameModel model) {
        this.model = model;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(new GameKeyListener());
        startGame();
    }

    public void startGame() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void pauseGame(Graphics g) {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (model.running) {
            for (int i = 0; i < SCREEN_HEIGHT/BLOCK_SIZE; i++) {
                g.drawLine(0, i * BLOCK_SIZE, SCREEN_WIDTH, i * BLOCK_SIZE);
            }
            for (int i = 0; i < SCREEN_WIDTH/BLOCK_SIZE; i++) {
                g.drawLine(i * BLOCK_SIZE, 0, i * BLOCK_SIZE, SCREEN_HEIGHT);
            }
            
            drawField(g);
            drawFigure(g);
        }
        else if (pause) {
            pauseGame(g);
        }
        else {
            gameOver(g);
        }
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
        public void keyPressed(KeyEvent e) {
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
                case KeyEvent.VK_ESCAPE:
                    if (!pause) {
                        timer.stop();
                        pause = true;
                    }
                    else {
                        timer.start();
                        pause = false;
                    }
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.move();
        repaint();
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.orange);
        g.setFont(new Font("GAME OVER", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics.stringWidth("GAME OVER")) / 2, SCREEN_HEIGHT / 3);
        g.setColor(Color.white);
        g.drawString("Score: " + model.getScore(), (SCREEN_WIDTH - metrics.stringWidth("Score: " + model.getScore())) / 2, 2 * SCREEN_HEIGHT / 3);
    }
}
