package com.leetcode.solution;


import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/5/3 6:28 下午
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 注意这儿不是s为null，而是s为空字符串，需要注意，空字符串为调用方
        if ("".equals(s)) {
            return true;
        }
        boolean result = false;
        for (int m = 0; m < wordDict.size(); m++) {
            String word = wordDict.get(m);
            for (int i = 0; i < s.length(); i++) {
                int wordLength = word.length();
                // 为了防止越界
                if (i + wordLength <= s.length() && s.substring(i, i + wordLength).equals(word)) {
                    // 不能直接去"ccbb"
                    //"ccbb" ["bc","cb"]这种情况直接去就GG
                    String sLeft = s.substring(0, i);
                    String sRight = s.substring(i + wordLength);
                    // 后面是与操作，因为左边和右边都需要满足
                    result = result || (wordBreak(sLeft, wordDict) && wordBreak(sRight, wordDict));

                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new LinkedList<>();
        Collections.addAll(wordDict, "cats","dog","sand","and","cat");
        System.out.println(new Solution139().wordBreak(s, wordDict));
    }
}

