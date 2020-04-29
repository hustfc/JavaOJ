package com.leetcode.solution;

import javafx.util.Pair;
import sun.awt.image.ImageWatched;

import java.util.*;
/**
 * @Author : fanc
 * @Date : 2020/4/28 8:46 下午
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 预处理
        Map<String, List<String>> dic = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i ++) {
                String dummyWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = dic.getOrDefault(dummyWord, new LinkedList<>());
                list.add(word);
                dic.put(dummyWord, list);
            }
        }

        // 广度遍历，需要用到链表
        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        // 访问矩阵
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while(!queue.isEmpty()) {
            Pair<String, Integer> wordPair = queue.removeFirst();
            String word = wordPair.getKey();
            int level = wordPair.getValue();
            for (int i = 0; i < word.length(); i ++) {
                String dummyWord = word.substring(0, i) + "*" + word.substring(i + 1);
                if (dic.containsKey(dummyWord)) {
                    List<String> list = dic.get(dummyWord);
                    for (String trueWord : list) {
                        if (endWord.equals(trueWord)) {
                            return level + 1;
                        }
                        if (!visited.getOrDefault(trueWord, false)) {
                            queue.add(new Pair<>(trueWord, level + 1));
                            visited.put(trueWord, true);
                        }
                    }
                }

            }
        }

        return 0;

    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new LinkedList<>();
        Collections.addAll(wordList, "hot","dot","dog","lot","log","cog");
        System.out.println(new Solution127().ladderLength(beginWord, endWord, wordList));
    }
}
