package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/6/19 5:06 下午
 */
public class Solution222 {
    private int treeDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth += 1;
            root = root.left;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        // 左边大于右边，说明右边的是满的，左边的要继续
        if (leftDepth > rightDepth) {
            // 本来是需要减1的，因为加上了此root所以不需要减
            return countNodes(root.left) + (1 << rightDepth);
        }
        else {
            // 相等说明左边已经满了，到右边了
            return countNodes(root.right) + (1 << leftDepth);
        }
    }
}
