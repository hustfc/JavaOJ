package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/6/1 12:40 下午
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i ++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == length - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;

    }
}
