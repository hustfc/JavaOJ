package com.leetcode.solution;

public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) return false;
        int cols = matrix[0].length;

        for(int j = cols - 1; j >= 0; j --) {
            int i;
            for(i = 0; i < rows; i ++) {
                if(matrix[i][j] == target) return true;
                else if(matrix[i][j] < target) continue;
                else break;
            }
            if(i == rows) return false;
            if(matrix[i][j] == target) return true;
        }

        return false;

    }
}
