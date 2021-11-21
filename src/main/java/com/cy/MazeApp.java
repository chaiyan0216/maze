package com.cy;

import com.cy.util.Arrow;
import com.cy.model.Block;
import com.cy.model.Maze;
import com.cy.util.Pen;

public class MazeApp {

    public static void main(String[] args) {
        Block[][] maze = new Maze(50, 50).init();
        Pen.draw(maze);
        Arrow.go(maze, 0, 1, maze.length - 1, maze[0].length - 2);
    }
}
