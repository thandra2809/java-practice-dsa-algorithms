package org.capone.question_3;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesLC994 {
    static void main() {

// Example 1 - Output: 4
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int timeToRot1 = orangesRotting(grid1);
        System.out.println(timeToRot1);
        System.out.println("*******************************");

// Example 2 - Output: -1
        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        int timeToRot2 = orangesRotting(grid2);
        System.out.println(timeToRot2);
        System.out.println("*******************************");

// Example 3 - Output: 0
        int[][] grid3 = {
                {0, 2}
        };
        int timeToRot3 = orangesRotting(grid3);
        System.out.println(timeToRot3);
        System.out.println("*******************************");


    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int freshOranges = 0;
        int timeToRot = 0;


        // put the already rotted oranges on queue

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (freshOranges == 0) return 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            timeToRot++;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];

                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows &&
                            newCol >= 0 && newCol < cols &&
                            grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        freshOranges--;
                        queue.offer(new int[]{newRow, newCol});
                    }

                }

            }


        }


        System.out.println("freshOranges: " + freshOranges);

        return freshOranges == 0 ? timeToRot : -1;
    }
}
