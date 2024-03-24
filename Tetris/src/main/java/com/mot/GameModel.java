package com.mot;

import java.util.Random;
import com.mot.figures.*;
import static com.mot.Constants.*;

public class GameModel {

    
    Random random;
    Figure currentFigure;
    boolean blocks[] = new boolean[GAME_BLOCKS];
    int positionFigure[] = new int[FIGURE_BLOCKS];

    GameModel () {
        random = new Random();
    }

    public Figure getFigure() {
        int type = random.nextInt(COUNT_FIGURE);
        return determineFigures(type);
    }

    private Figure determineFigures(int type) {
        switch (type) {
            case 0:
                return new IFigure();
            case 1:
                return new JFigure();
            case 2:
                return new LFigure();
            case 3:
                return new OFigure();
            case 4:
                return new SFigure();
            case 5:
                return new TFigure();
            default:
                return new ZFigure();
        }
    }

    public int getX(int number) {
        return number % BLOCKS_IN_LINE;
    }

    public int getY(int number) {
        return number / BLOCKS_IN_LINE;
    }

    public int getPosition(int number) {
        return INDENT_IN_BLOCKS + number % 4 + (number / 4) * BLOCKS_IN_LINE;
    }

    public boolean onRight() {
        boolean tmp = true;
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            if(((positionFigure[i] + 1) % BLOCKS_IN_LINE) == 0) {
                tmp = false;
            }
        }
        return tmp;
    }

    public boolean onLeft() {
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            if((positionFigure[i] % BLOCKS_IN_LINE) == 0) {
                return false;
            }
        }
        return true;
    }

    public void flip() {

    }

    public void newFigure() {
        currentFigure = getFigure();
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            positionFigure[i] = getPosition(currentFigure.getBlock(i));
        }
    }

    public void move() {
        for (int i = FIGURE_BLOCKS - 1; i >= 0; i--) {
            positionFigure[i] += BLOCKS_IN_LINE;
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

}
