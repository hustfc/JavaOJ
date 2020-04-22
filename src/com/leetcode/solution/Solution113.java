package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/4/21 8:57 下午
 */
public class Solution113 {
    private List<List<Integer>> results = new LinkedList<>();

    private int sum;

    private void helper(TreeNode root, List<Integer> result, int total) {
        total += root.val;
        if (total == sum && root.right == null && root.left == null) {
            result.add(root.val);
            results.add(new LinkedList<>(result));
            result.remove(result.size() - 1);
            return;
        }

        // 可能是负数，没说节点都是正数，可能越加越小，因此不能根据大小剪枝

        result.add(root.val);

        // 需要保留递归的现场
        if (root.left != null) {
            helper(root.left, result, total);
        }
        if (root.right != null) {
            helper(root.right, result, total);
        }

        result.remove(result.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        if (root != null) {
            helper(root, new LinkedList<>(), 0);
        }
        return results;
    }
}
