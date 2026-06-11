package org.capone.question_3;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_BFS {
    static void main() {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        NumberOfIslands_BFS solution = new NumberOfIslands_BFS();
        int result = solution.numIslands(grid);
        System.out.println("Number of Islands: " + result);


    }

    public int numIslands(char[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    bfs(grid,i,j,rows,cols);
                }
            }
        }


        return result;
    }

    private void bfs(char[][] grid, int i, int j, int rows, int cols) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int row = cur[0];
            int col = cur[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == '1') {

                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // mark visited on enqueue
                }

            }
        }

    }
}
