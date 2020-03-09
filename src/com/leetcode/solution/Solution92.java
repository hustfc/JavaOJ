package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/3/9 5:08 下午
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        int i = 0;
        while (i < m - 1) {
            p = p.next;
            i += 1;
        }
        ListNode pre = p, newHead = null;
        ListNode preNext = p.next;
        p = p.next;
        if (p == null) {
            return head;
        }
        i += 1;
        while (i <= n) {
            if (p != null) {
                ListNode nextNode = p.next;
                p.next = newHead;
                newHead = p;
                p = nextNode;
                i += 1;
            }
            else {
                pre.next = newHead;
                return dummyHead.next;
            }

        }
        if (newHead != null) {
            pre.next = newHead;
            preNext.next = p;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = null;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
        new Solution92().reverseBetween(node1, 1, 2);

    }
}

