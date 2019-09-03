package com.leetcode.solution;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2019-09-03 17:10
 * 78子集
 */
public class Solution78 {

    List<List<Integer>> output = new LinkedList<>();
    int[] nums;

    /**
     * 回溯函数
     * @param index   元素索引
     * @param current 当前结果
     */
    public void traceback(int index, LinkedList<Integer> current) {
        output.add(new LinkedList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            traceback(i + 1, current);
            current.removeLast();
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        traceback(0, new LinkedList<>());
        return output;
    }
}
