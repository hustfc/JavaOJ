package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/6/16 11:17 下午
 */
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 去小于等于num的第一个数字
            // 可能没有比num更小的数字，因此可能为null，需要考虑
            Integer floor = set.floor(nums[i]);
            if (floor != null && floor + t >= nums[i]) {
                return true;
            }
            // 取大于等于num的第一个数字
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && nums[i] + t >= ceiling) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
