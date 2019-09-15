package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2019-09-15 11:42
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            // 处理重复数字
            while (start < end && nums[start] == nums[start + 1]) {
                start++;
            }
            while (start < end && nums[end] == nums[end - 1]) {
                end--;
            }
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[start]) {
                // 左边有序{4,5,6,1,2,3}
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 右边有序
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 1};
        int target = 3;
        System.out.println(new Solution81().search(nums, target));
    }
}
