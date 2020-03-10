package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/3/9 9:40 下午
 */
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) {
            return new LinkedList<>();
        }
        List<String> result = new LinkedList<>();
        recursionIp(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void recursionIp(String s, int index, List<String> list, List<String> result) {
        if ((s.length() - index) > (4 - list.size()) * 3) {
            return;
        }
        if (list.size() == 4 && index == s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    stringBuilder.append(list.get(i));
                } else {
                    stringBuilder.append(".").append(list.get(i));
                }
            }
            result.add(stringBuilder.toString());
        }
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (Integer.parseInt(sub) > 255) {
                break;
            }
            if (sub.length() > 1 && "0".equals(s.substring(index, index + 1))) {
                break;
            }
            list.add(sub);
            recursionIp(s, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        String s =  "010010";
        System.out.println(new Solution93().restoreIpAddresses(s));
    }

}
