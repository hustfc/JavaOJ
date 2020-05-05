package com.leetcode.solution;

import java.util.Objects;

/**
 * @Author : fanc
 * @Date : 2020/5/3 11:20 下午
 */
public class EqualTest {
    public static void main(String[] args) {
        String string1 = "abc";
        String string2 = "abc";
        System.out.println(Objects.equals(string1, string2));
        System.out.println(string1.equals(string2));
    }


}
