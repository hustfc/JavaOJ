package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/5/13 11:40 上午
 */
public class Solution151 {

    /**
     * 翻转String，增加头尾指针更方便翻转每一个word
     *
     * @param sb 处理字符串的时候都先翻译成StringBuilder更加方便
     * @return 返回void就行了，因为StringBuilder直接更改引用
     */
    private void reverseString(StringBuilder sb, int left, int right) {
        // 两种方法更改String中的某一个字符
        // 1. StringBuilder
        // 2. char[] charArray = s.toCharArray
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    /**
     * 在这个里面重新创建一个StringBuilder，空间开销是最小的
     * @param s
     * @return StringBuilder
     */
    private StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left += 1;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right -= 1;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if(c != ' ') {
                sb.append(c);
            }
            else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left += 1;
        }
        return sb;
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = trimSpaces(s);
        reverseString(sb, 0, sb.length() - 1);
        int start = 0;
        int end;
        while (start < sb.length()) {
            end = start + 1;
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end += 1;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
        }
        return sb.toString();
    }
}
