package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/2/6 9:11 下午
 */
public class Solution91 {
    private int recursionDecodings(String s, int index) {
        if (index >= s.length()) {
            return 0;
        }
        if (s.charAt(index) == '0') {
            return recursionDecodings(s, index + 1);
        }
        int result = 0;
        if (index < s.length() -1) {
            int temp = (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0');
            if (temp > 10 && temp <= 26) {
                result += 1;
                result += recursionDecodings(s, index + 2);
            }
        }
        return result + recursionDecodings(s, index + 1);
    }

    public int numDecodings(String s) {
        return s.charAt(0) == '0' ? recursionDecodings(s, 1) : 1 + recursionDecodings(s, 0);
    }

    public static void main(String[] args) {
        String s = "10";
        System.out.println(new Solution91().numDecodings(s));
    }
}
