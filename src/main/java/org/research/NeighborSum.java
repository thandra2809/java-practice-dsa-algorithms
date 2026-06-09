package org.research;

import java.util.*;

class NeighborSum {

    private int[][] grid;
    private int n;
    private Map<Integer, int[]> posMap; // value → {row, col}

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.posMap = new HashMap<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                posMap.put(grid[row][col], new int[]{row, col});
            }
        }
    }

    public int adjacentSum(int value) {
        int[] pos = posMap.get(value);
        int row = pos[0];
        int col = pos[1];

        int[][] directions = {
            {-1,  0},   // top
            { 1,  0},   // bottom
            { 0, -1},   // left
            { 0,  1}    // right
        };

        return getSum(row, col, directions);
    }

    public int diagonalSum(int value) {
        int[] pos = posMap.get(value);
        int row = pos[0];
        int col = pos[1];

        int[][] directions = {
            {-1, -1},   // top-left
            {-1,  1},   // top-right
            { 1, -1},   // bottom-left
            { 1,  1}    // bottom-right
        };

        return getSum(row, col, directions);
    }

    private int getSum(int row, int col, int[][] directions) {
        int sum = 0;

        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                sum += grid[newRow][newCol];
            }
        }

        return sum;
    }

    public int[][] recreateGridWithAdjacentSum() {
        int[][] newGrid = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = grid[row][col];
                newGrid[row][col] = adjacentSum(value);
            }
        }

        return newGrid;
    }

    // ── NEW: Recreate grid where each cell = diagonalSum of original value ───
    public int[][] recreateGridWithDiagonalSum() {
        int[][] newGrid = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = grid[row][col];
                newGrid[row][col] = diagonalSum(value);
            }
        }

        return newGrid;
    }

    public int[][] recreateGridWithTotalSum() {
        int[][] newGrid = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = grid[row][col];
                newGrid[row][col] = adjacentSum(value) + diagonalSum(value);
            }
        }

        return newGrid;
    }

    // ── Helper: print any grid neatly ────────────────────────────────────────
    public static void printGrid(int[][] grid, String label) {
        System.out.println("\n── " + label + " ──");
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.printf("%4d", grid[row][col]);
            }
            System.out.println();
        }
    }


    static void main() {
        int[][] grid = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };

        NeighborSum ns = new NeighborSum(grid);

        printGrid(grid,                            "Original Grid");
        printGrid(ns.recreateGridWithAdjacentSum(),"Adjacent Sum Grid");
        printGrid(ns.recreateGridWithDiagonalSum(),"Diagonal Sum Grid");
        printGrid(ns.recreateGridWithTotalSum(),   "Total Sum Grid (Adjacent + Diagonal)");
    }
}