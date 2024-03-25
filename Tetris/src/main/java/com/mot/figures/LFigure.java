package com.mot.figures;

public class LFigure extends Figure{
    public LFigure() {
        type = 'L';
        direction = 'R';
        position = new int[4];
        this.position[0] = 0;
        this.position[1] = 1;
        this.position[2] = 2;
        this.position[3] = 4;
    }
}
