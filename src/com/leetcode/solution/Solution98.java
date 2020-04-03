package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/4/3 5:33 下午
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return recursionBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean recursionBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= min && root.val <= max) {
            return recursionBST(root.left, min, root.val) && recursionBST(root.right, root.val, max);
        }
        else {
            return false;
        }
    }
}
