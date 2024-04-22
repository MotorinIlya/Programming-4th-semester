package com.mot.model.figures;

import static com.mot.Constants.BLOCKS_IN_LINE;
import static com.mot.Constants.FIGURE_BLOCKS;

import com.mot.model.GameModel;

public class TFigure extends Figure {
    public TFigure(GameModel model) {
        this.model = model;
        type = 'T';
        direction = 'R';
        position = new int[FIGURE_BLOCKS];
        newPosition = new int[FIGURE_BLOCKS];
        this.position[0] = 3;
        this.position[1] = 4;
        this.position[2] = 5;
        this.position[3] = 14;
    }

    public void flip() {
        newPosition[1] = position[1];
        newPosition[2] = position[3];
        newPosition[3] = position[0];
        if (direction == 'R') {
            newPosition[0] = position[1] - BLOCKS_IN_LINE;
        }
        else if (direction == 'D') {
            newPosition[0] = position[1] + 1;
        }
        else if (direction == 'L') {
            newPosition[0] = position[1] + BLOCKS_IN_LINE;
        }
        else if (direction == 'U') {
            newPosition[0] = position[1] - 1;
        }
        isVerifyFlip();
    }
}
