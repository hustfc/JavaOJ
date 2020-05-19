package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/5/19 9:44 下午
 */
public class Solution165 {


    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int num1, num2;
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            // 可以直接用运算符表达式代替
//            if (i < v1.length) {
//                num1 = Integer.valueOf(v1[i]);
//            }
//            else {
//                num1 = 0;
//            }
//            if (i < v2.length) {
//                num2 = Integer.valueOf(v2[i]);
//            }
//            else {
//                num2 = 0;
//            }
            num1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            num2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (num1 > num2) {
                return 1;
            }
            else if (num1 < num2) {
                return -1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new Solution165().compareVersion("7.5.2.4", "7.5.3"));
    }
}
