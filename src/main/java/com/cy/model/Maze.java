package com.cy.model;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private final int M;
    private final int N;

    private final Block[][] maze;

    public Maze(int m, int n) {
        M = m % 2 == 0 ? m + 1 : m;
        N = n % 2 == 0 ? n + 1 : n;

        maze = new Block[M][N];
    }

    public Block[][] init() {
        initMaze();
        updateMaze();

        return maze;
    }

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

    private void updateMaze() {
        List<String> list = new ArrayList<>();
        boolean[][] visited = new boolean[M][N];

        visited[1][1] = true;
        list.add("1,1");

        randomBFS(list, visited);
    }

    private void randomBFS(List<String> list, boolean[][] visited) {
        while (!list.isEmpty()) {
            String current = list.remove((int) (Math.random() * list.size()));
            int curRow = Integer.parseInt(current.split(",")[0]);
            int curCol = Integer.parseInt(current.split(",")[1]);
            int up = curRow - 2;
            int down = curRow + 2;
            int left = curCol - 2;
            int right = curCol + 2;

            if (up >= 0 && !visited[up][curCol]) {
                maze[curRow - 1][curCol] = Block.EMPTY;
                visited[up][curCol] = true;
                list.add(up + "," + curCol);
            }
            if (down < M && !visited[down][curCol]) {
                maze[curRow + 1][curCol] = Block.EMPTY;
                visited[down][curCol] = true;
                list.add(down + "," + curCol);
            }
            if (left >= 0 && !visited[curRow][left]) {
                maze[curRow][curCol - 1] = Block.EMPTY;
                visited[curRow][left] = true;
                list.add(curRow + "," + left);
            }
            if (right < N && !visited[curRow][right]) {
                maze[curRow][curCol + 1] = Block.EMPTY;
                visited[curRow][right] = true;
                list.add(curRow + "," + right);
            }
        }
    }
}
