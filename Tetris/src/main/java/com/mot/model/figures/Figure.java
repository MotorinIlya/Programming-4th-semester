package com.mot.model.figures;

import static com.mot.Constants.*;

import com.mot.model.GameModel;

//all figure have direction: Right, Down, Left and Up. Direction needs for flip figure
// figure have one of the seven types: I, J, L, O, S, T, Z

public abstract class Figure {
    protected GameModel model;
    protected char type;
    protected char direction;
    protected int position[];    // position blocks in field
    protected int newPosition[]; // for safe flip

    public int getBlock(int block) throws IllegalArgumentException {
        if (block > 3) {
            throw new IllegalArgumentException();
        }
        else {
            return position[block];
        }
    }

    public void move() {
        for (int i = FIGURE_BLOCKS - 1; i >= 0; i--) {
            position[i] += BLOCKS_IN_LINE;
        }
    }

    public void shiftFigure(int shift) {
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            position[i] += shift;
        }
    }

    public void flip() {}

    protected void switchDirection() {
        switch (direction) {
            case 'R':
                direction = 'D';
                break;
            case 'D':
                direction = 'L';
                break;
            case 'L':
                direction = 'U';
                break;
            case 'U':
                direction = 'R';
                break;
        }
    }

    protected void isVerifyFlip() {
        if (model.isVerifyFlip(newPosition)) {
            verifyOnWall();
            for (int i = 0; i < FIGURE_BLOCKS; i++) {
                position[i] = newPosition[i];
            }
        }
        
        switchDirection();
    }

    protected void verifyOnWall() {
        boolean besideLeftWall = false;
        boolean besideRightWall = false;
        for (int i = 0; i < FIGURE_BLOCKS; i++) {
            if (newPosition[i] % BLOCKS_IN_LINE == 0) {
                besideLeftWall = true;
            }
            else if ((newPosition[i] + 1) % BLOCKS_IN_LINE == 0) {
                besideRightWall = true;
            }
        }

        boolean isLeft = false;
        boolean isRight = false;
        if (besideRightWall && besideLeftWall) {
            for (int i = 0; i < FIGURE_BLOCKS; i++) {
                if (position[i] % BLOCKS_IN_LINE == 0) {
                   isLeft = true;
                }
                else if ((position[i] + 1) % BLOCKS_IN_LINE == 0) {
                    isRight = true;
                }
            }
        }
        
        if (isLeft) {
            for (int i = 0; i < FIGURE_BLOCKS; i++) {
                newPosition[i]++;
            }
        }
        else if (isRight) {
            for (int i = 0; i < FIGURE_BLOCKS; i++) {
                if (type == 'I') {
                    newPosition[i] -= 2;
                }
                else {
                    newPosition[i]--;
                }
                
            }
        }
    }
}
