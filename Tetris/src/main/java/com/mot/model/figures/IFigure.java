package com.mot.model.figures;

import static com.mot.Constants.*;

import com.mot.model.GameModel;

public class IFigure extends Figure{
    public IFigure(GameModel model) {
        this.model = model;
        type = 'I';
        direction = 'R';
        position = new int[FIGURE_BLOCKS];
        newPosition = new int[FIGURE_BLOCKS];
        this.position[0] = 3;
        this.position[1] = 4;
        this.position[2] = 5;
        this.position[3] = 6;
    }

    public void flip() {
        int tmp = 0;
        if (direction == 'R' || direction == 'L') {
            tmp = (position[0] + position[3]) / 2;
            for (int i = FIGURE_BLOCKS - 1; i >= 0; i--) {
                newPosition[i] = tmp;
                tmp -= BLOCKS_IN_LINE;
            }
        }
        else if (direction == 'D' || direction == 'U') {
            tmp = position[3] - 1;
            for (int i = 0; i < FIGURE_BLOCKS; i++) {
                newPosition[i] = tmp;
                tmp++;
            }
        }
        isVerifyFlip();
    }
}
