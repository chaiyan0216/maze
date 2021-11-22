package com.cy.model;

public enum Block {
    WALL("▓▓"),
    EMPTY("  "),
    UP("↑"),
    DOWN("↓"),
    LEFT("←"),
    RIGHT("→"),
    BACK("[]"),
    FINAL("☆");

    // The width resize factor.
    private static final int RESIZE_FACTOR = 2;
    private final String symbol;

    Block(String symbol) {
        this.symbol = symbol;
    }

    public static int getResizeFactor() {
        return RESIZE_FACTOR;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
