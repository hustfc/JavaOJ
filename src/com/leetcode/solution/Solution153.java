package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/5/18 12:13 下午
 */
public class Solution153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[right]) {
                // middle可能是最小值
                right = middle;
            } else {
                // middle肯定不是最小值
                left = middle + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
