package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/5/5 12:20 下午
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        Set<ListNode> nodeSet = new HashSet<>();
        while (p != null) {
            if (nodeSet.contains(p)) {
                return p;
            }
            nodeSet.add(p);
            p = p.next;
        }
        return null;
    }
}
