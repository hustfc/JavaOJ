package com.leetcode.solution;

import java.util.*;
/**
 * @Author : fanc
 * @Date : 2020/4/19 12:04 下午
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;

        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < queueLength; i ++) {
                TreeNode treeNode = queue.removeFirst();
                if (flag) {
                    level.addLast(treeNode.val);
                }
                else {
                    level.addFirst(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(level);
            flag = !flag;
        }

        return result;
    }
}
