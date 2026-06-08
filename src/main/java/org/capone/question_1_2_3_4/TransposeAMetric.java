package org.capone.question_1_2_3_4;

import java.util.Arrays;

public class TransposeAMetric {
    static void main() {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12}
        };

        System.out.println(Arrays.deepToString(matrix));
        int[][] resultMatrix = transpose(matrix);


        System.out.println(Arrays.deepToString(resultMatrix));

    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] resultMatrix = new int[cols][rows];
        System.out.println("transpose matrix length:"+rows+","+cols);

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                resultMatrix[j][i] = matrix[i][j];
            }
        }

        return resultMatrix;
    }
}
