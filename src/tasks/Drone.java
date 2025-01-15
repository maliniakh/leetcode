package tasks;

import static java.lang.Integer.*;
import static java.lang.Integer.max;

public class Drone {
    static Direction[][] minimalHeight(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] solvedH = new int[rows][cols];
        Direction[][] dirs = new Direction[rows][cols];

        for (int n = 0; n < Math.max(rows, cols) /*todo*/; n++) {
            for(int y = rows - 1 - n; y >= 0; y--) {
                int x = cols - 1 - n;

                int rightSol = 0;
                if (x < cols - 1) {
                    rightSol = solvedH[y][x + 1];
                }

                int downSol = 0;
                if (y < rows - 1) {
                    downSol = solvedH[y + 1][x];
                }

                rightSol = max(heights[y][x], rightSol);
                downSol = max(heights[y][x], downSol);
                solvedH[y][x] = min(rightSol, downSol);

                dirs[y][x] = rightSol > downSol ? Direction.DOWN:Direction.RIGHT;
            }

            for(int x = cols - 1 - n; x >=0; x--) {
                int y = rows - 1 - n;
                System.out.println(heights[y][x]);

                int rightSol = 0;
                if (x < cols - 1) {
                    rightSol = solvedH[y][x + 1];
                }

                int downSol = 0;
                if (y < rows - 1) {
                    downSol = solvedH[y + 1][x];
                }

                solvedH[y][x] = min(max(heights[y][x], rightSol), max(heights[y][x], downSol));

                rightSol = max(heights[y][x], rightSol);
                downSol = max(heights[y][x], downSol);
                solvedH[y][x] = min(rightSol, downSol);

                dirs[y][x] = rightSol > downSol ? Direction.DOWN:Direction.RIGHT;
            }
        }

//        return solvedH[0][0];
        return dirs;
    }

    public static void main(String[] args) {
        int[][]  heights = {
                {0, 1, 5, 5, 5},
                {0, 0, 5, 5, 5},
                {5, 0, 5, 5, 5},
                {5, 0, 1, 0, 5},
                {5, 1, 5, 0, 0}
        };

        Direction[][] dirs = minimalHeight(heights);
        System.out.println("min height: " + dirs);

        int x = 0, y = 0;
        while(true) {
            if(y >= dirs.length || x >= dirs[0].length) {
                break;
            }

            System.out.println(dirs[y][x]);

            if (dirs[y][x] == Direction.DOWN) {
                y++;
            } else {
                x++;
            }
        }
    }
}

enum Direction {
    RIGHT,
    DOWN
}
