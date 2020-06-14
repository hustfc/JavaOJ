package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/6/14 4:19 下午
 */
public class Solution215 {
    private int result;
    private int m;

    private void partition(int[] nums, int start, int end) {
        int low = start, high = end;
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high -= 1;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low += 1;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        if (low == m) {
            result = nums[low];
            return;
        } else if (low < m) {
            partition(nums, low + 1, end);
        } else {
            partition(nums, start, low - 1);
        }


    }

    public int findKthLargest(int[] nums, int k) {
        m = nums.length - k;
        partition(nums, 0, nums.length - 1);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new Solution215().findKthLargest(nums, k));
    }
}
