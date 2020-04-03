package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/3/19 10:54 上午
 */
public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i ++) {
            for (int j = 0; j <= s2.length(); j ++) {
                if (i == 0 && j == 0) {
                    matrix[i][j] = true;
                }
                else if (i == 0) {
                    matrix[i][j] = matrix[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
                else if (j == 0) {
                    matrix[i][j] = matrix[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                else {
                    matrix[i][j] = (matrix[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (matrix[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return matrix[s1.length()][s2.length()];
    }
}
