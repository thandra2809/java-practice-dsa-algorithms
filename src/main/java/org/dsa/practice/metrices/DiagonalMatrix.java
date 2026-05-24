package org.dsa.practice.metrices;

public class DiagonalMatrix {

    static void main() {

        int[][] arr1 = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 2, 0, 0, 0},
                {0, 0, 3, 0, 0},
                {0, 0, 0, 4, 0},
                {0, 0, 0, 0, 5}
        };

        boolean isDiagonal1 = checkIfMatrixIsDiagonal(arr1);

        int[][] arr2 = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 2, 0, 0, 5},
                {0, 0, 3, 0, 0},
                {0, 0, 0, 4, 0},
                {0, 0, 0, 0, 5}
        };

        boolean isDiagonal2 = checkIfMatrixIsDiagonal(arr2);
    }

    private static boolean checkIfMatrixIsDiagonal(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        if (rows != cols) {
            System.out.println("The matrix is not a diagonal");
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i != j && arr[i][j] != 0) {
                    System.out.println("The matrix is not a diagonal");
                    return false;
                }
            }
        }
        System.out.println("The matrix is diagonal");
        return true;
    }


}
