package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/4/3 5:57 下午
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
            }
        }
        return false;
    }
}

