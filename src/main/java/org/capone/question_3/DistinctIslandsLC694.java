package org.capone.question_3;

import java.util.HashSet;
import java.util.Set;

public class DistinctIslandsLC694 {

    static void main() {

        int[][] grid = {
                {0, 1, 0, 0, 0,0,1,1},
                {1, 1, 0, 0, 0,0,1,1},
                {0, 0, 0, 1, 1,0,0,0},
                {0, 0, 0, 1, 1,0,0,0}
        };

        int numberOfDistinctIslands = 0;

        numberOfDistinctIslands = numDistinctIslands(grid);
        System.out.println(numberOfDistinctIslands);

    }

    public static int numDistinctIslands(int[][] grid) {

        StringBuilder path;
        Set<String> visitedUniquePaths = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 1) {
                    path = new StringBuilder();
                    dfs(grid, r, c, rows, cols, 'S', path);
                    visitedUniquePaths.add(path.toString());

                }


            }

        }

        return visitedUniquePaths.size();
    }

    private static StringBuilder dfs(int[][] grid, int r, int c, int rows, int cols, char s, StringBuilder path) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return path;
        }

        if (grid[r][c] == 0) {
            return path;
        }

        if (grid[r][c] == 1) {
            grid[r][c] = 0;  // mark as visited
            path.append(s);
            dfs(grid, r + 1, c, rows, cols, 'D', path);
            dfs(grid, r - 1, c, rows, cols, 'U', path);
            dfs(grid, r, c + 1, rows, cols, 'R', path);
            dfs(grid, r, c - 1, rows, cols, 'L', path);
            path.append('B'); // backtrack marker
        }

        return path;
    }


}
