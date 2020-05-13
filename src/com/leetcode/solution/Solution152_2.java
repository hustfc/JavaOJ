package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/5/13 3:47 下午
 */
public class Solution152_2 {
    public String reverseWords(String s) {
        // 去除开头和结尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        /**
         * .	Any character (may or may not match line terminators), 任意字符
         * X?	X, once or not at all       零个或一个
         * X*	X, zero or more times       零个或多个
         * X+	X, one or more times        一个或多个
         * X{n}	X, exactly n times          x出现n次
         * X{n,}	X, at least n times     x出现至少n次
         * X{n,m}	X, at least n but not more than m times 出现n~m次
         * java中对"\"这个符号需要使用\进行转义，所以字符是\\s，如果只是s的话，那么只会匹配字符s
         * @param args
         */
        List<String> wordList = Arrays.asList(s.split("\\s+"));

        //List里面每一个元素reverse，所以每个单词仍然顺序ok
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
