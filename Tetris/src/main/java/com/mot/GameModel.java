package com.mot;

import java.util.Random;
import com.mot.figures.*;
import static com.mot.Constants.*;

public class GameModel {

    private Random random;
    private Figure currentFigure;
    boolean running = false;
    private boolean blocks[] = new boolean[GAME_BLOCKS];
    int score;

    GameModel () {
        random = new Random();
        running = true;
        score = 0;
        newFigure();
    }

    public void newFigure() {
        int type = random.nextInt(COUNT_FIGURE);
        currentFigure = determineFigures(type);
    }

    private Figure determineFigures(int type) {
        switch (type) {
            case 0:
                return new IFigure(this);
            case 1:
                return new JFigure(this);
            case 2:
                return new LFigure(this);
            case 3:
                return new OFigure(this);
            case 4:
                return new SFigure(this);
            case 5:
                return new TFigure(this);
            default:
                return new ZFigure(this);
        }
    }

    public int getX(int number) {
        return number % BLOCKS_IN_LINE;
    }

    public int getY(int number) {
        return number / BLOCKS_IN_LINE;
    }

    public boolean onRight() {
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            if(((currentFigure.getBlock(i) + 1) % BLOCKS_IN_LINE) == 0) {
                return false;
            }
            else if (blocks[currentFigure.getBlock(i) + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean onLeft() {
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            if((currentFigure.getBlock(i) % BLOCKS_IN_LINE) == 0) {
                return false;
            }
            else if (blocks[currentFigure.getBlock(i) - 1]) {
                return false;
            }
        }
        return true;
    }

    public void flip() {
        currentFigure.flip();
    }

    public void move() {
        if (running) {
            if (checkFigure()) {
                currentFigure.move();
            }
            checkLines();
            checkGameOver();
        }
    }

    public int getBlock(int i) {
        return currentFigure.getBlock(i);
    }

    public boolean getBlocks(int i) {
        return blocks[i];
    }

    public boolean isVerifyFlip(int [] position) {
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            if (blocks[position[i]]) {
                return false;
            }
        }
        return true;
    }

    public void shiftFigure(int shift) {
        if (shift > 0 && onRight()) {
            currentFigure.shiftFigure(shift);            
        }
        else if (shift < 0 && onLeft()) {
            currentFigure.shiftFigure(shift);
        }
    }

    public boolean checkFigure() {
        for (int i = 0; i < FIGURE_BLOCKS; i++) {

            int isBlock = currentFigure.getBlock(i) + BLOCKS_IN_LINE;

            if ((isBlock >= GAME_BLOCKS) || blocks[isBlock]) {
                for (int j = 0; j < FIGURE_BLOCKS; j++) {
                    blocks[currentFigure.getBlock(j)] = true;
                }
                newFigure();
                return false;
            }

        }
        return true;
    }
    
    public void checkLines() {
        int countClearLines = 0;
        for (int i = 0; i < BLOCKS_IN_COLUMN; i++) {
            int count_blocks = 0;
            for (int j = 0; j < BLOCKS_IN_LINE; j++) { //verify lines
                if (blocks[i * BLOCKS_IN_LINE + j]) {
                    count_blocks++;
                }
            }
            if (count_blocks == BLOCKS_IN_LINE) { 
                countClearLines++;
                for (int j = 0; j < BLOCKS_IN_LINE; j++) { //delete line
                    blocks[i * BLOCKS_IN_LINE + j] = false;
                }
                for (int j = (i + 1) * BLOCKS_IN_LINE - 1; j >= BLOCKS_IN_LINE; j--) { //fall blocks
                    blocks[j] = blocks[j - BLOCKS_IN_LINE];
                }
            }
        }
        if (countClearLines > 0) {
            score += addScore(countClearLines);
        }
    }

    public void checkGameOver() {
        for (int i = 0; i < BLOCKS_IN_LINE; i++) {
            if (blocks[i]) {
                running = false;
                break;
            }
        }
    }

    public int addScore(int lines) {
        switch (lines) {
            case 1:
                return 40;
            case 2:
                return 100;
            case 3:
                return 300;
            case 4:
                return 1200;
            default:
                return 0;
            
        }
    }

    public int getScore() {
        return score;
    }

    public void restart() {
        for (int i = 0; i < GAME_BLOCKS; i++) {
            blocks[i] = false;
        }
        newFigure();
        score = 0;
    }

}
