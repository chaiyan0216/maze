package com.cy.model;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private final int M;
    private final int N;

    private final Block[][] maze;

    /**
     * Set maze size, let row size and col size to be odd.
     *
     * @param m the row size.
     * @param n the col size.
     */
    public Maze(int m, int n) {
        M = m % 2 == 0 ? m + 1 : m;
        N = n % 2 == 0 ? n + 1 : n;

        maze = new Block[M][N];
    }

    /**
     * Init maze.
     *
     * @return the maze.
     */
    public Block[][] init() {
        initMaze();
        updateMaze();

        return maze;
    }

    /**
     * Odd is empty, even is wall.
     * Let entry be the right block of left-up corner.
     * Let exit be the left block of right-bottom corner.
     */
    private void initMaze() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i % 2 == 0 || j % 2 == 0) {
                    maze[i][j] = Block.WALL;
                } else {
                    maze[i][j] = Block.EMPTY;
                }
            }
        }

        maze[0][1] = Block.EMPTY;
        maze[M - 1][N - 2] = Block.EMPTY;
    }

    /**
     * Update maze by random bfs.
     */
    private void updateMaze() {
        List<String> list = new ArrayList<>();
        boolean[][] visited = new boolean[M][N];

        visited[1][1] = true;
        list.add("1,1");

        randomBFS(list, visited);
    }

    private void randomBFS(List<String> list, boolean[][] visited) {
        int[][] directions = new int[][]{{-2, 0}, {2, 0}, {0, -2}, {0, 2}};

        while (!list.isEmpty()) {
            String current = list.remove((int) (Math.random() * list.size()));
            int curRow = Integer.parseInt(current.split(",")[0]);
            int curCol = Integer.parseInt(current.split(",")[1]);

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + directions[i][0];
                int nextCol = curCol + directions[i][1];

                if (nextRow >= 0 && nextRow < M && nextCol >= 0 && nextCol < N && !visited[nextRow][nextCol]) {
                    maze[(curRow + nextRow) / 2][(curCol + nextCol) / 2] = Block.EMPTY;
                    visited[nextRow][nextCol] = true;
                    list.add(nextRow + "," + nextCol);
                }
            }
        }
    }
}
