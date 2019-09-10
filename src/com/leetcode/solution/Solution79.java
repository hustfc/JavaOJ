package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2019-09-03 17:55
 * 单词搜索
 */
public class Solution79 {
    /**
     * 定义变量
     */
    private boolean[][] marked;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int cols;
    private char[][] board;
    private String word;

    /**
     * 判断是否在这个位置是否在矩阵里面
     * @param i
     * @param j
     * @return
     */
    private boolean inArea(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    /**
     * 矩阵递归回溯深度搜索
     * @param i
     * @param j
     * @param wordIndex
     * @return
     */
    private boolean matrixDfs(int i, int j, int wordIndex) {
        if (board[i][j] == word.charAt(wordIndex) && !marked[i][j]) {
            if (wordIndex == word.length() - 1) {
                return true;
            }
            marked[i][j] = true;
            for (int m = 0; m < direction.length; m++) {
                int newX = i + direction[m][0], newY = j + direction[m][1];
                if (inArea(newX, newY) && matrixDfs(newX, newY, wordIndex + 1)) {
                    return true;
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    /**
     * 对每个矩阵每个点作为起点开始搜索
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrixDfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'a'}};
        String word = "aaa";
        Solution79 solution = new Solution79();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}
