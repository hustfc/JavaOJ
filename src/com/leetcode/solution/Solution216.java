package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/6/15 10:03 下午
 */
public class Solution216 {
    private List<List<Integer>> results = new LinkedList<>();
    private int n;
    private int k;

    private void combinationHelper(int sum, List<Integer> result) {

        if (sum == n && result.size() == k) {
            results.add(result);
            return;
        }
        if (result.size() >= k) {
            return;
        }

        for (int i = result.size() == 0 ? 1 : result.get(result.size() - 1) + 1; i <= 9 && sum + i <= n; i ++) {
            sum += i;
            result.add(i);
            combinationHelper(sum, new LinkedList<>(result));
            sum -= i;
            result.remove(result.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        combinationHelper(0, new LinkedList<>());
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution216().combinationSum3(3, 7));
    }

}
