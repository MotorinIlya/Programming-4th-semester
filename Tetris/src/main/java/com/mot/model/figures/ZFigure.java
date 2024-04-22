package com.mot.model.figures;

import static com.mot.Constants.BLOCKS_IN_LINE;
import static com.mot.Constants.FIGURE_BLOCKS;

import com.mot.model.GameModel;

public class ZFigure extends Figure{
    public ZFigure(GameModel model) {
        this.model = model;
        type = 'Z';
        direction = 'R';
        position = new int[FIGURE_BLOCKS];
        newPosition = new int[FIGURE_BLOCKS];
        this.position[0] = 3;
        this.position[1] = 4;
        this.position[2] = 14;
        this.position[3] = 15;
    }

    public void flip() {
        newPosition[1] = position[1];
        newPosition[2] = position[0];
        if (direction == 'R') {
            newPosition[0] = position[1] - BLOCKS_IN_LINE;
            newPosition[3] = position[2] - 1;
        }
        else if (direction == 'D') {
            newPosition[0] = position[1] + 1;
            newPosition[3] = position[2] - BLOCKS_IN_LINE;
        }
        else if (direction == 'L') {
            newPosition[0] = position[1] + BLOCKS_IN_LINE;
            newPosition[3] = position[2] + 1;
        }
        else if (direction == 'U') {
            newPosition[0] = position[1] - 1;
            newPosition[3] = position[2] + BLOCKS_IN_LINE;
        }
        isVerifyFlip();
    }
}
