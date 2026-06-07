package org.capone.question_3;

import java.util.LinkedList;
import java.util.Queue;

public class CountOfBattleShipsLC419_BFS {

    static void main() {

        char[][] board1 = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        int boardBattleships1 = countBattleships(board1);

        System.out.println(boardBattleships1);


//        char[][] board2 = {
//                {'.'}
//        };
//
//        int boardBattleships2 = countBattleships(board2);


    }


    public static int countBattleships(char[][] board) {
        int count = 0;

        int rows = board.length;
        int columns = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    bfs(board, i, j, rows, columns);
                }
            }
        }


        return count;
    }

    public static void bfs(char[][] board, int row, int col, int rows, int columns) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        board[row][col] = '.';  // marking as visited

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];

            for (int[] dir : dirs) {
                int newR = cur[0] + dir[0];
                int newC = cur[1] + dir[1];

                if (newR >= 0 && newR < rows &&
                        newC >= 0 && newC < columns &&
                        board[newR][newC] == 'X') {

                    board[newR][newC] = '.';
                    queue.offer(new int[]{newR, newC});
                }
            }
        }

    }
}
