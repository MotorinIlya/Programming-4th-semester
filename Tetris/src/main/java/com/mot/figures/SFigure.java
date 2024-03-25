package com.mot.figures;

public class SFigure extends Figure{
    public SFigure() {
        type = 'S';
        direction = 'R';
        position = new int[4];
        this.position[0] = 1;
        this.position[1] = 2;
        this.position[2] = 4;
        this.position[3] = 5;
    }
}
