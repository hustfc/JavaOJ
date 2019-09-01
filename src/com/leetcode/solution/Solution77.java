package com.leetcode.solution;

import java.util.*;
/**
 * @Author : fanc
 * @Date : 2019-09-01 19:25
 */
public class Solution77 {
    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;

    public void traceback(int first, LinkedList<Integer> current) {
        if (current.size() == k) {
            output.add(current);
        }

    }
}
