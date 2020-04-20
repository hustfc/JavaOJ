package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/4/20 8:00 下午
 */
public class Solution109 {
    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPre = null;

        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 需要让链表断开
        if (slowPre != null) {
            slowPre.next = null;
        }

        return slow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode middle = findMiddleNode(head);
        TreeNode root = new TreeNode(middle.val);


        // 如果链表只有一个节点的时候，middle=head，就会造成重复
        if (middle != head) {
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(middle.next);
        }

        return root;
    }
}
