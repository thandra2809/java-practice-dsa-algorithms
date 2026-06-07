package org.capone.question_3;

public class CountOfBattleShipsLC419_DFS {

    static void main() {

        char[][] board1 = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        int boardBattleships1 = countBattleships(board1);
        System.out.println(boardBattleships1);


        char[][] board2 = {
                {'.'}
        };

        int boardBattleships2 = countBattleships(board2);
        System.out.println(boardBattleships2);


    }


    public static int countBattleships(char[][] board) {
        int count = 0;

        int rows = board.length;
        int columns = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j, rows, columns);
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] board, int row, int col, int rows, int columns){
        if (row < 0 || row >= rows || col < 0 || col >= columns) return;

        if (board[row][col] != 'X') return;

        board[row][col] = '.';
        dfs(board, row + 1, col, rows, columns);
        dfs(board, row - 1, col, rows, columns);
        dfs(board, row, col + 1, rows, columns);
        dfs(board, row, col - 1, rows, columns);
    }
}
