package com.mot;

public final class Constants {
    public static final int SCREEN_WIDTH = 500;
    public static final int SCREEN_HEIGHT = 1000;

    public static final int BLOCK_SIZE = 50;
    public static final int FIGURE_BLOCKS = 4;
    public static final int COUNT_FIGURE = 7;

    public static final int GAME_BLOCKS = (SCREEN_HEIGHT * SCREEN_WIDTH) / (BLOCK_SIZE * BLOCK_SIZE);
    public static final int BLOCKS_IN_LINE = SCREEN_WIDTH / BLOCK_SIZE;
    public static final int BLOCKS_IN_COLUMN = SCREEN_HEIGHT / BLOCK_SIZE;

    public static final int INDENT = (SCREEN_WIDTH - (4 * BLOCK_SIZE)) / 2;
    public static final int INDENT_IN_BLOCKS = INDENT / BLOCK_SIZE;

    public static final int DELAY = 150;
    
}
