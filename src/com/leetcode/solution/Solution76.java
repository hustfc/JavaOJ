package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : fanc:最小覆盖子串
 * @Date : 2019-08-26 20:16
 * hello
 */
public class Solution76 {
    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dicT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int count = dicT.getOrDefault(t.charAt(i), 0);
            dicT.put(t.charAt(i), count + 1);
        }

        //需要的数目
        int required = dicT.size();

        //已经构建的数目
        int formed = 0;

        // 左右两个指针
        int l = 0, r = 0;

        // 窗口字母个数
        Map<Character, Integer> windowCounts = new HashMap<>();

        // 长度 l r
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dicT.containsKey(c) && windowCounts.get(c).intValue() == dicT.get(c).intValue()) {
                System.out.println(1);
                formed++;
            }

            while (l <= r && formed == required) {
                System.out.println("l" + l + "r" + r);
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;

                }

                //尝试左指针向右移动
                l ++;
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dicT.containsKey(c) && windowCounts.get(c).intValue() < dicT.get(c).intValue()) {
                    formed --;
                }
            }
            r ++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
