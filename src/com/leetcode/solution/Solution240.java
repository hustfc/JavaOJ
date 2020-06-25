package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/6/25 10:46 下午
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                j += 1;
            }
            else {
                i -= 1;
            }
        }
        return false;
    }
}
