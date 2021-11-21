package com.cy.model;

public enum Block {
    WALL("▓▓"),
    EMPTY("  "),
    UP("↑"),
    DOWN("↓"),
    LEFT("←"),
    RIGHT("→"),
    BACK("□"),
    FINAL("☆");

    private final String symbol;

    Block(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
