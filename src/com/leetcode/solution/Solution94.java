package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/3/12 5:22 下午
 */
public class Solution94 {
    private void recursionInorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursionInorder(root.left, result);
            result.add(root.val);
            recursionInorder(root.right, result);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recursionInorder(root, result);
        return result;
    }
}
