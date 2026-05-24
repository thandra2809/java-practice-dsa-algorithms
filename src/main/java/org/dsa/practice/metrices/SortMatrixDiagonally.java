package org.dsa.practice.metrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMatrixDiagonally {
    static void main() {

        int[][] arr1 = new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};

        int[][] sortedArray = sortDiagonally(arr1);

        System.out.println("Sorted diagonal matrix" + Arrays.deepToString(sortedArray));

    }

    private static int[][] sortDiagonally(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // start at row-0 and sort until all columns covered
        for (int column = 0; column < cols; column++) {
            sortIt(mat, 0, column, rows, cols);
        }

        // start at column=0 and sort till all rows are reached
        for (int row = 1; row < rows; row++) {
            sortIt(mat, row, 0, rows, cols);
        }
        return mat;
    }

    private static void sortIt(int[][] mat, int row, int column, int rows, int cols) {
        List<Integer> list = new ArrayList<>();
        int r = row;
        int c = column;

        while(r<rows && c<cols) {
            list.add(mat[r][c]);
            r++;
            c++;
        }

        Collections.sort(list);

        r = row;
        c = column;

        int index = 0;
        while(r<rows && c<cols) {
            mat[r][c] = list.get(index);
            r++;
            c++;
            index++;
        }

    }
}
