package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/5/17 9:57 下午
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        // 使用result[0]来表示中间结果
        int minNum = nums[0], maxNum = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxTemp = maxNum, minTemp = minNum;
            // 计算的时候需要考虑这个数字，这个时候maxNum已经更改了，因此需要保存值
            maxNum = Math.max(nums[i], Math.max(nums[i] * minTemp, nums[i] * maxTemp));
            minNum = Math.min(nums[i], Math.min(nums[i] * minTemp, nums[i] * maxTemp));
            // 但是result更新的时候不一定需要这个数字
            result = Math.max(maxNum, result);

        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new Solution152().maxProduct(new int[]{-4, -3, -2}));
    }

}
