package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/4/30 8:01 下午
 */


public class Solution138 {
    // 反之类冲突，定义一个内部类
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node p = head;
        while (p != null) {
            // 生成新的交错复制链表
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;
        Node newHead = p.next;
        // 初始化random
        while (p != null) {
            Node pNext = p.next;
            // random可能为null
            pNext.random = p.random != null ? p.random.next : null;
            p = pNext.next;
        }
        // 断开链表
        p = head;
        while (p != null) {
            Node pNext = p.next;
            p.next = pNext.next;
            pNext.next = pNext.next != null ? pNext.next.next : null;
            p = p.next;
        }

        return newHead;
    }
}
