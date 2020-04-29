package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/4/29 10:11 下午
 */
public class Solution129 {
    int totalSum = 0;

    private void helper(TreeNode root, int sum) {
        sum = sum * 10 + root.val;
        if (root.left != null) {
            helper(root.left, sum);
        }
        if (root.right != null) {
            helper(root.right, sum);
        }
        if (root.left == null && root.right == null) {
            totalSum += sum;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root != null) {
            helper(root, 0);
        }
        return totalSum;
    }
}
