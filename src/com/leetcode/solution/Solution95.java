package com.leetcode.solution;
import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/3/14 2:27 下午
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<TreeNode>();
        }
        return recursionDFS(1, n);
    }
    private List<TreeNode> recursionDFS(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftRoots = recursionDFS(start, i - 1);
            List<TreeNode> rightRoots = recursionDFS(i + 1, end);
            for (TreeNode left : leftRoots) {
                for (TreeNode right : rightRoots) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
