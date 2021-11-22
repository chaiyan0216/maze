package com.cy.model;

import com.googlecode.lanterna.TextColor;

public enum Block {
    WALL("▓▓", TextColor.ANSI.CYAN, null),
    EMPTY("  ", TextColor.ANSI.CYAN, null),
    UP("↑", TextColor.ANSI.RED, null),
    DOWN("↓", TextColor.ANSI.RED, null),
    LEFT("←", TextColor.ANSI.RED, null),
    RIGHT("→", TextColor.ANSI.RED, null),
    BACK("[]", null, TextColor.ANSI.RED),
    FINAL("☆", null, TextColor.ANSI.GREEN);

    // The width resize factor.
    private static final int RESIZE_FACTOR = 2;
    private final String symbol;
    private final TextColor fore;
    private final TextColor back;

    Block(String symbol, TextColor fore, TextColor back) {
        this.symbol = symbol;
        this.fore = fore;
        this.back = back;
    }

    public static int getResizeFactor() {
        return RESIZE_FACTOR;
    }

    public TextColor getFore() {
        return fore == null ? TextColor.ANSI.DEFAULT : fore;
    }

    public TextColor getBack() {
        return back == null ? TextColor.ANSI.DEFAULT : back;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
