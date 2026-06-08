package org.capone.question_3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryMatrixDistanceLC542 {
    static void main() {

        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
                {1, 1, 1}
        };

        int[][] result = updateMatrix(mat);
        System.out.println(Arrays.deepToString(result));

    }

    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int row = cur[0];
            int col = cur[1];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newCol >= 0 && newRow >= 0 && newRow < rows && newCol < cols) {
                    if (result[newRow][newCol] > result[row][col] + 1) {
                        result[newRow][newCol] = result[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }


            }

        }


        System.out.println("mat = " + Arrays.deepToString(mat));
        System.out.println("result = " + Arrays.deepToString(result));

        return result;
    }
}
