package com.cy.util;

import com.cy.model.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arrow {

    private static final int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Block[] blocks = new Block[] {Block.UP, Block.DOWN, Block.LEFT, Block.RIGHT};

    private Arrow() {}

    public static boolean go(Block[][] maze, int startRow, int startCol, int endRow, int endCol) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (startRow == endRow && startCol == endCol) {
            maze[startRow][startCol] = Block.FINAL;
            Pen.update(startRow, startCol, maze[startRow][startCol].toString());
            return true;
        }

        List<Integer> shuffle = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            shuffle.add(i);
        }
        Collections.shuffle(shuffle);

        for (int i : shuffle) {
            int nextRow = startRow + directions[i][0];
            int nextCol = startCol + directions[i][1];

            if (nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length
                    && maze[nextRow][nextCol] == Block.EMPTY) {
                maze[startRow][startCol] = blocks[i];
                Pen.update(startRow, startCol, maze[startRow][startCol].toString());
                if (go(maze, nextRow, nextCol, endRow, endCol)) {
                    return true;
                }
            }
        }

        maze[startRow][startCol] = Block.BACK;
        Pen.update(startRow, startCol, maze[startRow][startCol].toString());
        return false;
    }
}
