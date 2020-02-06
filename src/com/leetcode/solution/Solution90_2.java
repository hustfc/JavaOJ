package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/1/13 8:46 下午
 */
public class Solution90_2 {
    private static List<List<Integer>> Resursion(List<Integer> result, int[] nums, int index) {
        List<List<Integer>> newResults = new ArrayList<>();
        newResults.add(new ArrayList<>(result));
        for (int i = index; i < nums.length; i++) {
            // 排序之后保证每次加进来的都是不一样的元素，大于index的时候生效
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            result.add(nums[i]);
            newResults.addAll(Resursion(result, nums, i + 1));
            result.remove(result.size() - 1);
        }
        return newResults;

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return Resursion(new LinkedList<>(), nums, 0);
    }

}
