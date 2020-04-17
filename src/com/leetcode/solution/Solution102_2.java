package com.leetcode.solution;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/4/17 9:44 下午
 */
public class Solution102_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i ++) {
                TreeNode node = queue.removeFirst();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            result.add(level);
        }

        return result;
    }
}
