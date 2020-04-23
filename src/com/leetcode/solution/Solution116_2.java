package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/4/23 11:11 下午
 */
public class Solution116_2 {
    private void connectHelper(Node left, Node right) {
        if (left != null) {
            left.next = right;
            connectHelper(left.left, left.right);
            connectHelper(left.right, right.left);
            connectHelper(right.left, right.right);
        }
    }
    public Node connect(Node root) {
        if (root != null) {
            connectHelper(root.left, root.right);
        }
        return root;
    }
}
