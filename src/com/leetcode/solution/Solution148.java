package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/5/11 6:05 下午
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = findMiddle(head);
        ListNode right = node.next;
        node.next = null;
        ListNode left = sortList(head);
        right = sortList(right);
        return mergeTwoLists(left, right);
    }

    /**
     * 找到链表中间节点
     * @param head
     * @return 中间节点的前一个节点
     */
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 合并两个有序链表
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val <= head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        }
        else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }
    }




}
