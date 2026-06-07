package org.capone.question_3;

public class MaxAreaOfIsland {

    static void main() {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        int maxAreaOfTheIsland = 0;

        maxAreaOfTheIsland = maxAreaOfIsland(grid);

        System.out.println(maxAreaOfTheIsland);

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j,rows,cols));
                }
            }
        }

        return maxArea;
    }

    public static int dfs(int[][] grid, int row, int column,int rows,int cols) {

        if (row < 0 || row >= rows || column < 0 || column >= cols) {
            return 0;
        }

        if (grid[row][column] != 1) {
            return 0;
        }

        //  mark as visited if the value is 1
        grid[row][column] = 0;
        return 1 + dfs(grid, row + 1, column,rows,cols) + dfs(grid, row - 1, column,rows,cols) + dfs(grid, row, column + 1,rows,cols) + dfs(grid, row, column - 1,rows,cols);
    }
}
