package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2019-08-17 21:10
 */
public class Test {
    private static void helper(int k) {
        k -= 100;
    }
    public static void main(String[] args) {
        int k = 100;
        helper(k);
        System.out.println(k);
    }
}
