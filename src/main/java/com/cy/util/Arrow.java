package com.cy.util;

import com.cy.model.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arrow {

    private static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Block[] blocks = new Block[]{Block.UP, Block.DOWN, Block.LEFT, Block.RIGHT};

    private Arrow() {
    }

    /**
     * Random BFS 4 directions.
     *
     * @param maze     the maze.
     * @param startRow the entry row.
     * @param startCol the entry col.
     * @param endRow   the exit row.
     * @param endCol   the exit col.
     * @return true if meet exit.
     */
    public static boolean go(Block[][] maze, int startRow, int startCol, int endRow, int endCol) {
        // Add sleep to delay each step.
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return true if meet exit.
        if (startRow == endRow && startCol == endCol) {
            Pen.update(startRow, startCol, Block.FINAL);
            maze[startRow][startCol] = Block.FINAL;
            return true;
        }

        // Shuffle directions.
        List<Integer> shuffle = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            shuffle.add(i);
        }
        Collections.shuffle(shuffle);

        // BFS
        for (int i : shuffle) {
            int nextRow = startRow + directions[i][0];
            int nextCol = startCol + directions[i][1];

            if (nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length
                    && maze[nextRow][nextCol] == Block.EMPTY) {
                maze[startRow][startCol] = blocks[i];
                Pen.update(startRow, startCol, maze[startRow][startCol]);
                if (go(maze, nextRow, nextCol, endRow, endCol)) {
                    return true;
                }
            }
        }

        // Can't go to exit, update block and return false.
        Pen.update(startRow, startCol, Block.BACK);
        maze[startRow][startCol] = Block.BACK;
        return false;
    }
}
