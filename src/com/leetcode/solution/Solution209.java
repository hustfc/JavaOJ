package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/6/13 6:14 下午
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int result = 0;
        int total = 0;

        while (right < nums.length) {
            total += nums[right++];
            if (total >= s) {
                while (total >= s) {
                    total -= nums[left++];
                }
                // left总会+1
                if (result == 0 || right - left + 1 < result) {
                    result = right - left + 1;
                }
            }
        }
        return result;
    }
}
