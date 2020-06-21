package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/6/21 5:55 下午
 */
public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if ((i < nums.length - 1 && nums[i + 1] != nums[i] + 1) || i == nums.length - 1) {
                result.add(nums[i] == start ? Integer.toString(start) : start + "->" + nums[i]);
                if (i != nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution228().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
