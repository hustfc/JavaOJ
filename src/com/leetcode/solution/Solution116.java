package com.leetcode.solution;

import java.util.LinkedList;

/**
 * @Author : fanc
 * @Date : 2020/4/23 10:36 下午
 */
public class Solution116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < levelNum; i++) {
                Node node = queue.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }

                if (i < levelNum - 1) {
                    node.next = queue.peek();
                }
            }
            // 不要在循环中随便更改循环终止条件，需要在for循环外面更改
            levelNum = levelNum << 1;
        }
        return root;
    }
}
