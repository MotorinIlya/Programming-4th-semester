package com.mot;

import javax.swing.*;

import com.mot.figures.Figure;

import java.awt.event.*;
import java.awt.*;
import static com.mot.Constants.*;

public class GamePanel extends JPanel implements ActionListener{

    boolean blocks[] = new boolean[GAME_BLOCKS];
    int positionFigure[] = new int[FIGURE_BLOCKS];

     
    GameModel model;
    Timer timer;
    boolean running = false;
    Figure currentFigure;

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
        running = true;
        newFigure();
        timer.start();
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
            if (blocks[i]) {
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
            g.fillRect(model.getX(positionFigure[i]) * BLOCK_SIZE, 
            model.getY(positionFigure[i]) * BLOCK_SIZE, 
            BLOCK_SIZE, 
            BLOCK_SIZE);
        }
    }

    public void move() {
        for (int i = FIGURE_BLOCKS - 1; i >= 0; i--) {
            positionFigure[i] += BLOCKS_IN_LINE;
        }
    }

    public void checkLines() { // блоки не падают
        for (int i = 0; i < BLOCKS_IN_COLUMN; i++) {
            int count_blocks = 0;
            for (int j = 0; j < BLOCKS_IN_LINE; j++) 
            {
                if (blocks[i * BLOCKS_IN_LINE + j]) {
                    count_blocks++;
                }
            }
            if (count_blocks == BLOCKS_IN_LINE) {
                for (int j = 0; j < BLOCKS_IN_LINE; j++) {
                    blocks[i * BLOCKS_IN_LINE + j] = false;
                }
            }
        }
    }

    public void checkFigure() {
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            if ((positionFigure[i] + BLOCKS_IN_LINE >= GAME_BLOCKS) || blocks[positionFigure[i] + BLOCKS_IN_LINE]) {
                for (int j = 0; j < FIGURE_BLOCKS; j++) {
                    blocks[positionFigure[j]] = true;
                }
                newFigure();
                break;
            }

        }
    }

    public void newFigure() {
        currentFigure = model.getFigure();
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            positionFigure[i] = getPosition(currentFigure.getBlock(i));
        }
    }



    public class GameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    if (onRight()) {
                        for (int i = 0; i < FIGURE_BLOCKS; i++) {
                            positionFigure[i]++;
                        }
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (onLeft()) {
                        for (int i = 0; i < FIGURE_BLOCKS; i++) {
                            positionFigure[i]--;
                        }
                    }
                    break;
                case KeyEvent.VK_UP:
                    flip();
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        checkFigure();
        checkLines();
        repaint();
    }

    private int getPosition(int number) {
        return INDENT_IN_BLOCKS + number % 4 + (number / 4) * BLOCKS_IN_LINE;
    }



    private boolean onRight() {
        boolean tmp = true;
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            if(((positionFigure[i] + 1) % BLOCKS_IN_LINE) == 0) {
                tmp = false;
            }
        }
        return tmp;
    }

    private boolean onLeft() {
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            if((positionFigure[i] % BLOCKS_IN_LINE) == 0) {
                return false;
            }
        }
        return true;
    }

    private void flip() {

    }
    
}
