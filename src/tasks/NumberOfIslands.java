package tasks;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] processed = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for(int x = 0; x < grid[0].length; x++) {
            for(int y = 0; y < grid.length; y++) {
                if(grid[y][x] == '1' && !processed[y][x]) {
                    dfs(x, y, grid, processed);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int x, int y, char[][] grid, boolean[][] processed) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        processed[y][x] = true;

//        Arrays.binarySearch(new int[]{}, 1, (ip1, ip2) -> {
//
//        })

        while(!stack.isEmpty()) {
            int[] coords = stack.pop();
            x = coords[0];
            y = coords[1];
//            System.out.println(x + " " + y + " popped");

            if (x > 0 && !processed[y][x - 1] && grid[y][x - 1] == '1') {                    // todo: przypadek ze grid ma 1x1
                stack.push(new int[]{x - 1, y});
                processed[y][x - 1] = true;
            }
            if (x < grid[0].length - 1 && !processed[y][x + 1] && grid[y][x + 1] == '1') {
                stack.push(new int[]{x + 1, y});
                processed[y][x + 1] = true;
            }
            if (y > 0 && !processed[y - 1][x] && grid[y - 1][x] == '1') {
                stack.push(new int[]{x, y - 1});
                processed[y - 1][x] = true;
            }
            if (y < grid.length - 1 && !processed[y + 1][x] && grid[y + 1][x] == '1') {
                stack.push(new int[]{x, y + 1});
                processed[y + 1][x] = true;
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        int islands = new NumberOfIslands().numIslands(grid);
        System.out.println("islands " + islands);
        
        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        islands = new NumberOfIslands().numIslands(grid);
        System.out.println("islands " + islands);

        grid = new char[][]{
                {'0', '1', '0', '0', '0'},
                {'0', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        islands = new NumberOfIslands().numIslands(grid);
        System.out.println("islands " + islands);

        grid = new char[][]{
                {'1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '1', '1'}
        };

        islands = new NumberOfIslands().numIslands(grid);
        System.out.println("islands " + islands);
    };
}
