package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/5/6 11:31 上午
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 将链表一分为2
        ListNode slowNode = getMiddleNode(head);
        ListNode middleNode = slowNode.next;
        slowNode.next = null;

        // 翻转
        ListNode newHead = reverseList(middleNode);

        // 两个链表交错连接
        while (newHead != null) {
            ListNode newHeadNext = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = newHeadNext;
        }



    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;
        while (p != null) {
            ListNode pNext = p.next;
            p.next = newHead;
            newHead = p;
            p = pNext;

        }
        return newHead;
    }

    // 找出链表中点，用fast.next判断更好一些，因为可以断开链表
    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast =fast.next.next;
        }
        return slow;
    }
}
