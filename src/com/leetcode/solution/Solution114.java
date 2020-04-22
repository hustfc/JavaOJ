package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/4/22 9:25 下午
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                // 左子树记得要掐掉
                root.left = null;
            }
            root = root.right;
        }
    }
}
