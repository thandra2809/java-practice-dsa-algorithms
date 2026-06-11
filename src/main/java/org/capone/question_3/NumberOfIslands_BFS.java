package org.capone.question_3;

public class NumberOfIslands_BFS {
    static void main() {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        NumberOfIslands_BFS solution = new NumberOfIslands_BFS();
        int result = solution.numIslands(grid);
        System.out.println("Number of Islands: " + result);


    }

    public int numIslands(char[][] grid) {
        int result = 0;


        return result;
    }
}
