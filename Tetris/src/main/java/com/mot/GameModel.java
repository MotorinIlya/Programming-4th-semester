package com.mot;

import java.util.Random;
import com.mot.figures.*;
import static com.mot.Constants.*;

public class GameModel {

    static final int COUNT_FIGURE = 7;
    Random random;

    GameModel () {
        random = new Random();
    }

    public Figure getFigure() {
        int type = random.nextInt(COUNT_FIGURE);
        return determineFigures(type);
    }

    private Figure determineFigures(int type) {
        switch (type) {
            case 0:
                return new IFigure();
            case 1:
                return new JFigure();
            case 2:
                return new LFigure();
            case 3:
                return new OFigure();
            case 4:
                return new SFigure();
            case 5:
                return new TFigure();
            default:
                return new ZFigure();
        }
    }

    public int getX(int number) {
        return number % BLOCKS_IN_LINE;
    }

    public int getY(int number) {
        return number / BLOCKS_IN_LINE;
    }

    public int getPosition(int number) {
        return INDENT_IN_BLOCKS + number % 4 + (number / 4) * BLOCKS_IN_LINE;
    }
    
}
