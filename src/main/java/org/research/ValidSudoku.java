package org.research;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char v = board[r][c];
                if (v == '.') continue;
                if (!seen.add("r" + r + v) ||
                    !seen.add("c" + c + v) ||
                    !seen.add("b" + (r / 3) + (c / 3) + v)) {
                    return false;
                }
            }
        }
        return true;
    }

    // ── Helper to print the board neatly ──────────────────────────────────────
    static void printBoard(char[][] board) {
        System.out.println("+-------+-------+-------+");
        for (int r = 0; r < 9; r++) {
            System.out.print("| ");
            for (int c = 0; c < 9; c++) {
                System.out.print(board[r][c] + " ");
                if (c == 2 || c == 5) System.out.print("| ");
            }
            System.out.println("|");
            if (r == 2 || r == 5) System.out.println("+-------+-------+-------+");
        }
        System.out.println("+-------+-------+-------+");
    }

    public static void main(String[] args) {
        ValidSudoku sol = new ValidSudoku();

        // ── Test 1: Valid board ───────────────────────────────────────────────
        char[][] validBoard = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Test 1 — Valid board:");
        printBoard(validBoard);
        System.out.println("Result: " + sol.isValidSudoku(validBoard));   // true
        System.out.println();

        // ── Test 2: Duplicate in a row ────────────────────────────────────────
        char[][] rowDupe = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','7'}   // <-- two 7s in row 8
        };
        System.out.println("Test 2 — Duplicate in row (two 7s in last row):");
        printBoard(rowDupe);
        System.out.println("Result: " + sol.isValidSudoku(rowDupe));      // false
        System.out.println();

        // ── Test 3: Duplicate in a column ────────────────────────────────────
        char[][] colDupe = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'5','.','.','.','.','.','.','.','.'}   // <-- 5 already in col 0 (row 0)
        };
        System.out.println("Test 3 — Duplicate in column (5 in col 0 twice):");
        printBoard(colDupe);
        System.out.println("Result: " + sol.isValidSudoku(colDupe));      // false
        System.out.println();

        // ── Test 4: Duplicate in a 3x3 box ───────────────────────────────────
        char[][] boxDupe = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','5','.','.','.','.','6','.'},  // <-- 5 in top-left box (rows 0-2, cols 0-2) twice
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Test 4 — Duplicate in 3x3 box (5 appears twice in top-left box):");
        printBoard(boxDupe);
        System.out.println("Result: " + sol.isValidSudoku(boxDupe));      // false
        System.out.println();

        // ── Test 5: Empty board (all dots) ────────────────────────────────────
        char[][] emptyBoard = new char[9][9];
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                emptyBoard[r][c] = '.';
        System.out.println("Test 5 — Empty board (all dots):");
        printBoard(emptyBoard);
        System.out.println("Result: " + sol.isValidSudoku(emptyBoard));   // true
        System.out.println();

        // ── Test 6: Single cell filled ────────────────────────────────────────
        char[][] singleCell = new char[9][9];
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                singleCell[r][c] = '.';
        singleCell[4][4] = '5';
        System.out.println("Test 6 — Single cell filled (5 in center):");
        printBoard(singleCell);
        System.out.println("Result: " + sol.isValidSudoku(singleCell));   // true

        // ── Summary ───────────────────────────────────────────────────────────
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("Test 1 (valid board)          : " + sol.isValidSudoku(validBoard)  + "  (expected true)");
        System.out.println("Test 2 (row duplicate)        : " + sol.isValidSudoku(rowDupe)     + " (expected false)");
        System.out.println("Test 3 (column duplicate)     : " + sol.isValidSudoku(colDupe)     + " (expected false)");
        System.out.println("Test 4 (box duplicate)        : " + sol.isValidSudoku(boxDupe)     + " (expected false)");
        System.out.println("Test 5 (empty board)          : " + sol.isValidSudoku(emptyBoard)  + "  (expected true)");
        System.out.println("Test 6 (single cell)          : " + sol.isValidSudoku(singleCell)  + "  (expected true)");
    }
}