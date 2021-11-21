package com.cy.util;

import com.cy.model.Block;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Pen {

    private static final int RESIZE_FACTOR = 2;

    private static Terminal terminal;
    private static TextGraphics textGraphics;

    private Pen() {}

    static {
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
            textGraphics = terminal.newTextGraphics();
            terminal.clearScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void draw(Block[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                textGraphics.putString(RESIZE_FACTOR * j, i, maze[i][j].toString());
            }
        }
        flush();
    }

    public static void update(int i, int j, String s) {
        textGraphics.putString(RESIZE_FACTOR * j, i, s);
        flush();
    }

    private static void flush() {
        try {
            terminal.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
