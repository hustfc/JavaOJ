package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/6/22 9:42 下午
 */
public class Solution230 {
    private int result;
    private int k;

    private void helper(TreeNode root) {
        if (k > 0 && root.left != null) {
            helper(root.left);
        }
        k -= 1;
        if (k == 0) {
            result = root.val;
        }
        if (k > 0 && root.right != null) {
            helper(root.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return result;
    }

}
