package com.leetcode.solution;

import java.util.*;
/**
 * @Author : fanc
 * @Date : 2020/5/7 11:12 上午
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            result.add(root.val);
            if (root.left != null) {
                result.addAll(preorderTraversal(root.left));
            }
            if (root.right != null) {
                result.addAll(preorderTraversal(root.right));
            }
        }
        return result;
    }
}
