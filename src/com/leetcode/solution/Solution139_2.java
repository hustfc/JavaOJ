package com.leetcode.solution;
import java.util.*;
/**
 * @Author : fanc
 * @Date : 2020/5/3 7:31 下午
 */
public class Solution139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
