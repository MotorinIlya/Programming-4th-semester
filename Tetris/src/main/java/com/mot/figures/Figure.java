package com.mot.figures;

//fields determine with the position of the part of the figure
// |0|1|2|3|
// |4|5|6|7|

public abstract class Figure {
    protected char type;
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
