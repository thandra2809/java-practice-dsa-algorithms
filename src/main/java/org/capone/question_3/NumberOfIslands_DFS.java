package org.capone.question_3;

public class NumberOfIslands_DFS {
    static void main() {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        NumberOfIslands_DFS solution = new NumberOfIslands_DFS();
        int result = solution.numIslands(grid);
        System.out.println("Number of Islands: " + result);


    }

    private int numIslands(char[][] grid) {
        int numberOfIslands = 0;

        int rows = grid.length;
        int columns = grid[0].length-1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(grid,i,j,rows,columns);
                }
            }
        }

        return numberOfIslands;
    }

    private void dfs(char[][] grid, int row, int column, int rows, int columns) {
        if (!(row < 0 || row >= rows || column < 0 || column >= columns)&&grid[row][column]=='1') {
           grid[row][column] = '0';
            dfs(grid,row-1,column,rows,columns);
           dfs(grid,row+1,column,rows,columns);
           dfs(grid,row,column-1,rows,columns);
           dfs(grid,row,column+1,rows,columns);
        }

    }
}
