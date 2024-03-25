package com.mot.figures;

//fields determine with the position of the part of the figure. 
// |0|1|2|3|
// |4|5|6|7|
//all figure have direction: Right, Down, Left and Up. Direction needs for flip figure
// figure have one of the seven types: I, J, L, O, S, T, Z

public abstract class Figure {
    protected char type;
    protected char direction;
    protected int position[];

    public int getBlock(int block) throws IllegalArgumentException {
        if (block > 3) {
            throw new IllegalArgumentException();
        }
        else {
            return position[block];
        }
    }
}
