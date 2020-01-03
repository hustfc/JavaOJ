package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2019/11/13 8:53 下午
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode lowStart = new ListNode(-1), lowEnd = lowStart;
        ListNode highStart = new ListNode(-1), highEnd = highStart;
        for (ListNode p = head; p != null; p = p.next) {
            System.out.println(p.val);
            if (p.val < x) {
                lowEnd.next = p;
                lowEnd = p;
            }
            else {
                highEnd.next = p;
                highEnd = p;
            }
            System.out.println("lowEnd: " + lowEnd.val + "highEnd:" + highEnd.val);
        }
        lowEnd.next = null;
        highEnd.next = null;
        if (lowStart.next == null) {
            return highStart.next;
        }
        else {
            lowEnd.next = highStart.next;
            return lowStart.next;
        }

    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(2);
        ListNode p6 = new ListNode(4);
        ListNode p7 = new ListNode(-1);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        ListNode newHead = new Solution86().partition(p1, 3);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
