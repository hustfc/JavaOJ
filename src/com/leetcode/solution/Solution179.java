package com.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author : fanc
 * @Date : 2020/5/22 10:15 下午
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] numsString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1 + o2).compareTo(o2 + o1);
            }
        });
        String result = "";
        // 处理边界情况 int[] nums = new int[]{0, 0};
        for (int i = 0; i < numsString.length; i++) {
            if (result.equals("") && numsString[i].equals("0")) {
                continue;
            }
            result += numsString[i];
        }
        return result.equals("") ? "0" : result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        System.out.println(new Solution179().largestNumber(nums));
        System.out.println("A".compareTo("B"));
    }
}
