package com.cy;

import com.cy.util.Arrow;
import com.cy.model.Block;
import com.cy.model.Maze;
import com.cy.util.Pen;

public class MazeApp {

    public static void main(String[] args) {
        // Read m*n from args.
        int m = 50, n = 50;
        if (args != null && args.length == 2) {
            m = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);
        }

        Block[][] maze = new Maze(m, n).init();
        Pen.draw(maze);
        Arrow.go(maze, 0, 1, maze.length - 1, maze[0].length - 2);
    }
}
