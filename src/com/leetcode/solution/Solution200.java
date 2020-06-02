package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/6/2 9:08 下午
 */
public class Solution200 {
    private char[][] grid;

    private void ClearZero (int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        ClearZero(i - 1, j);
        ClearZero(i + 1, j);
        ClearZero(i, j - 1);
        ClearZero(i, j + 1);
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int result = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    result += 1;
                    ClearZero(i, j);
                }
            }
        }
        return result;
    }
}
