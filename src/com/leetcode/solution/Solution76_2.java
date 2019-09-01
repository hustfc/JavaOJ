package com.leetcode.solution;

import javafx.util.Pair;

import java.util.*;


/**
 * @Author : fanc
 * @Date : 2019-09-01 13:56
 * hello test
 */
public class Solution76_2 {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> dicT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int count = dicT.getOrDefault(t.charAt(i), 0);
            dicT.put(t.charAt(i), count + 1);
        }

        List<Pair<Integer, Character>> filterS = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dicT.containsKey(c)) {
                filterS.add(new Pair<>(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        int required = dicT.size();
        int[] ans = {-1, 0, 0};

        Map<Character, Integer> window = new HashMap<>();

        while (r < filterS.size()) {
            char c = filterS.get(r).getValue();
            int count = window.getOrDefault(c, 0);
            window.put(c, count + 1);
            if (window.get(c).intValue() == dicT.get(c).intValue()) {
                formed++;
            }
            while (l <= r && formed == required) {
                c = filterS.get(l).getValue();
                int start = filterS.get(l).getKey();
                int end = filterS.get(r).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                l++;
                window.put(c, window.get(c) - 1);
                if (window.get(c).intValue() < dicT.get(c).intValue()) {
                    formed--;
                }
            }
            r ++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}
