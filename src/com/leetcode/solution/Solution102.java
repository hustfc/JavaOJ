package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/4/17 8:38 下午
 */
public class Solution102 {
    private List<List<Integer>> result = new LinkedList<>();

    private void helper(TreeNode root, int level) {
        if (level > result.size()) {
            result.add(new LinkedList<>());
        }
        result.get(level - 1).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            helper(root, 1);
        }
        return result;
    }
}
