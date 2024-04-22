package com.mot.model.figures;

import static com.mot.Constants.BLOCKS_IN_LINE;
import static com.mot.Constants.FIGURE_BLOCKS;

import com.mot.model.GameModel;

public class JFigure extends Figure {
    public JFigure(GameModel model) {
        this.model = model;
        type = 'J';
        direction = 'R';
        position = new int[FIGURE_BLOCKS];
        newPosition = new int[FIGURE_BLOCKS];
        this.position[0] = 3;
        this.position[1] = 4;
        this.position[2] = 5;
        this.position[3] = 15;
    }

    public void flip() {
        newPosition[0] = position[2];
        newPosition[1] = position[3];
        if (direction == 'R') {
            newPosition[2] = position[3] + BLOCKS_IN_LINE;
            newPosition[3] = newPosition[2] - 1;
        }
        else if (direction == 'D') {
            newPosition[2] = position[3] - 1;
            newPosition[3] = newPosition[2] - BLOCKS_IN_LINE;
        }
        else if (direction == 'L') {
            newPosition[2] = position[3] - BLOCKS_IN_LINE;
            newPosition[3] = newPosition[2] + 1;
        }
        else if (direction == 'U') {
            newPosition[2] = position[3] + 1;
            newPosition[3] = newPosition[2] + BLOCKS_IN_LINE;
        }
        isVerifyFlip();
    }
}
