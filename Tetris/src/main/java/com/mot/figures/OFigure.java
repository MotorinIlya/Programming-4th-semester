package com.mot.figures;

import com.mot.GameModel;

public class OFigure extends Figure {
    public OFigure(GameModel model) {
        this.model = model;
        type = 'O';
        direction = 'R';
        position = new int[4];
        this.position[0] = 4;
        this.position[1] = 5;
        this.position[2] = 14;
        this.position[3] = 15;
    }

    public void flip() {
        switchDirection();
    }
}