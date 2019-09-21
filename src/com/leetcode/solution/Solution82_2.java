package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2019-09-21 21:45
 */
public class Solution82_2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while (fast != null) {
            if (fast.next == null || (fast.next != null && fast.val != fast.next.val)) {
                // 如果中间没有重复元素
                if (fast == slow.next) {
                    slow = fast;
                }
                // 如果中间很多重复元素，去掉重复元素
                else {
                    slow.next = fast.next;
                }
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}
