package com.mot.figures;

import static com.mot.Constants.*;

import com.mot.GameModel;

public class LFigure extends Figure{
    public LFigure(GameModel model) {
        this.model = model;
        type = 'L';
        direction = 'R';
        position = new int[FIGURE_BLOCKS];
        newPosition = new int[FIGURE_BLOCKS];
        this.position[0] = 3;
        this.position[1] = 4;
        this.position[2] = 5;
        this.position[3] = 13;
    }

    public void flip() {
        newPosition[3] = position[1];
        newPosition[0] = position[2];
        if (direction == 'R') {
            newPosition[1] = position[2] + BLOCKS_IN_LINE;
            newPosition[2] = newPosition[1] + BLOCKS_IN_LINE;
        }
        else if (direction == 'D') {
            newPosition[1] = position[2] - 1;
            newPosition[2] = newPosition[1] - 1;
        }
        else if (direction == 'L') {
            newPosition[1] = position[2] - BLOCKS_IN_LINE;
            newPosition[2] = newPosition[1] - BLOCKS_IN_LINE;
        }
        else if (direction == 'U') {
            newPosition[1] = position[2] + 1;
            newPosition[2] = newPosition[1] + 1;
        }
        isVerifyFlip();
    }
}
