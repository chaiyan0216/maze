package com.cy.util;

import com.cy.model.Block;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Pen {

    private static Terminal terminal;
    private static TextGraphics textGraphics;
    private static int resizeFactor;

    private Pen() {
    }

    // Init terminal when Pen class is loaded.
    static {
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
            textGraphics = terminal.newTextGraphics();
            terminal.clearScreen();
            resizeFactor = Block.getResizeFactor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Draw the full maze.
     *
     * @param maze the maze.
     */
    public static void draw(Block[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                textGraphics.putString(resizeFactor * j, i, maze[i][j].toString());
            }
        }
        flush();
    }

    /**
     * Update one block at (row, col).
     *
     * @param row   the block row.
     * @param col   the block col.
     * @param block the block.
     */
    public static void update(int row, int col, Block block) {
        textGraphics.putString(resizeFactor * col, row, block.toString());
        flush();
    }

    /**
     * Refresh screen.
     */
    private static void flush() {
        try {
            terminal.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
