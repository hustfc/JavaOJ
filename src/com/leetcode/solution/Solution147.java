package com.leetcode.solution;

import java.util.List;

/**
 * @Author : fanc
 * @Date : 2020/5/9 8:10 下午
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        for (ListNode node = head; node != null;) {
            ListNode cur = node;
            node = node.next;

            if (cur.val < prev.val) {
                prev = dummy;
            }

            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }

            cur.next = prev.next;
            prev.next = cur;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new Solution147().insertionSortList(node1));
        System.out.println("test");
    }
}
