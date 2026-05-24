package org.dsa.practice.metrices;

// leet-code 2679

import java.util.ArrayList;
import java.util.Arrays;

public class SumInMatrix2679 {
    static void main() {

        int[][] arr1 = new int[][]{
                {7,2,1},
                {6,4,2},
                {6,5,3},
                {3,2,1}
        };

        int sumInMatrix = getSumInMatrix(arr1);


        int[][] arr2 = new int[][]{
                {1}
        };

        int sumInMatrix2 = getSumInMatrix(arr2);

        System.out.println();
        System.out.println(sumInMatrix);
        System.out.println(sumInMatrix2);

    }

    private static int getSumInMatrix(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;

        // Step 1: Sort each row in ascending order
        // so the largest is always at the last column
        for (int[] row : nums) {
            Arrays.sort(row);
        }

        int score = 0;

        // Step 2: For each column from right to left (largest to smallest)
        // find the max value across all rows at that column
        for (int j = cols - 1; j >= 0; j--) {
            int maxAcrossRows = Integer.MIN_VALUE;

            for (int i = 0; i < rows; i++) {
                maxAcrossRows = Math.max(maxAcrossRows, nums[i][j]);
            }

            score += maxAcrossRows;
        }

        return score;
    }

}
