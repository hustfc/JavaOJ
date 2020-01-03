package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2019/12/17 10:14 下午
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (slow != null) {
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = fast;
        }
        return head;
    }
}
