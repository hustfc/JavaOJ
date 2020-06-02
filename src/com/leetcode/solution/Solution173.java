package com.leetcode.solution;

import java.util.Stack;

/**
 * @Author : fanc
 * @Date : 2020/5/25 9:35 下午
 */
public class Solution173 {
    class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();

        private void popLeft(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public BSTIterator(TreeNode root) {
            popLeft(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                popLeft(node.right);
            }
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
