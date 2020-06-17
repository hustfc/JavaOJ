package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/6/17 8:01 下午
 */


/**
 * [-1,2147483647] 相减可能会溢出，因此需要考虑溢出问题，转化成为long来考虑
 * 1
 * 2147483647
 */

public class Solution220_BucketSort {
    private long getKey(long num, long w) {
        // 如果w=5，那么-1 -2 -3 -4 -5都属于这个区间，首先转为0-4然后处理
        return num < 0 ? (num + 1) / w - 1 : num / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 边界情况，绝对值差不可能小于0
        if (t < 0) {
            return false;
        }
        // 如果t=4，那么0-4位一个区间，有5个元素
        long w = (long)t + 1;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long key = getKey(nums[i], w);
            if (map.containsKey(key)) {
                return true;
            }
            if (map.containsKey(key - 1) && Math.abs(map.get(key - 1) - nums[i]) <= t) {
                return true;
            }
            if (map.containsKey(key + 1) && Math.abs(map.get(key + 1) - nums[i]) <= t) {
                return true;
            }
            map.put(key, (long)nums[i]);
            // 如果k=4，那么插入5的时候，已经需要删除0了
            if (i >= k) {
                map.remove(getKey(nums[i - k], w));
            }
        }
        return false;
    }
}
