package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2019-09-10 17:19
 * 删除排序数组中的重复元素
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int count = 0, elem = nums[0];
        int lastValidIndex = 0, index = 0;
        while (index < nums.length) {
            if (nums[index] == elem) {
                count++;
                if (count <= 2) {
                    nums[lastValidIndex++] = nums[index];
                }
                index++;
            } else {
                elem = nums[index];
                count = 0;
            }
        }
        return lastValidIndex;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(new Solution80().removeDuplicates(nums));
    }
}
