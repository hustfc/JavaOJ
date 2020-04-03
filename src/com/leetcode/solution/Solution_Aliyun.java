package com.leetcode.solution;

import java.util.*;
/**
 * @Author : fanc
 * @Date : 2020/3/17 5:24 下午
 */
public class Solution_Aliyun {
    private Map<Integer, String> names;
    private List<List<String>>  recursionDFS(String num, int index, List<String> result) {
        List<List<String>> results = new LinkedList<>();
        if (index == num.length()) {
            results.add(new ArrayList<>(result));
        }
        for (int i = index; i <= index + 1 && i < num.length(); i ++) {
            String sub = num.substring(index, i + 1);
            Integer number = Integer.parseInt(sub);
            if (number <= 29) {
                result.add(names.get(number));
                results.addAll(recursionDFS(num, i + 1, result));
                result.remove(result.size() - 1);
            }
        }
        return results;

    }
    public List<List<String>> findNum(int num, Map<Integer, String> names){
        this.names = names;
        return recursionDFS(String.valueOf(num), 0, new LinkedList<>());
    }

    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        for (int i = 1; i <= 29; i ++) {
            names.put(i, String.valueOf("杭州" + i));
        }
        System.out.println(names);
        System.out.println(new Solution_Aliyun().findNum(23412, names));
    }
}
