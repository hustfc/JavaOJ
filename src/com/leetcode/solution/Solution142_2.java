package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/5/5 12:31 下午
 */
public class Solution142_2 {
    private ListNode getSlowNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slowNode = getSlowNode(head);
        if (slowNode == null) {
            return null;
        }
        ListNode p = head;
        while (p != slowNode) {
            p = p.next;
            slowNode = slowNode.next;
        }
        return p;
    }
}
