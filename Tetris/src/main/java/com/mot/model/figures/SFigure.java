package com.mot.model.figures;

import static com.mot.Constants.BLOCKS_IN_LINE;
import static com.mot.Constants.FIGURE_BLOCKS;

import com.mot.model.GameModel;

public class SFigure extends Figure{
    public SFigure(GameModel model) {
        this.model = model;
        type = 'S';
        direction = 'R';
        position = new int[FIGURE_BLOCKS];
        newPosition = new int[FIGURE_BLOCKS];
        this.position[0] = 4;
        this.position[1] = 5;
        this.position[2] = 13;
        this.position[3] = 14;
    }

    public void flip() {
        newPosition[0] = position[0];
        newPosition[1] = position[3];
        if (direction == 'R') {
            newPosition[3] = position[0] - 1;
            newPosition[2] = newPosition[3] - BLOCKS_IN_LINE;
        }
        else if (direction == 'D') {
            newPosition[3] = position[0] - BLOCKS_IN_LINE;
            newPosition[2] = newPosition[3] + 1;
        }
        else if (direction == 'L') {
            newPosition[3] = position[0] + 1;
            newPosition[2] = newPosition[3] + BLOCKS_IN_LINE;
        }
        else if (direction == 'U') {
            newPosition[3] = position[0] + BLOCKS_IN_LINE;
            newPosition[2] = newPosition[3] - 1;
        }
        isVerifyFlip();
    }
}
