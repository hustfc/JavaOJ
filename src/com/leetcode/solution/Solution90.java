package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/1/12 8:19 下午
 */
public class Solution90 {

    private static List<List<Integer>> Resursion(List<Integer> result, int[] nums, int index) {
        List<List<Integer>> newResults = new ArrayList<>();
        newResults.add(new ArrayList<>(result));
        for (int i = index; i < nums.length; i++) {
            result.add(nums[i]);
            newResults.addAll(Resursion(result, nums, i + 1));
            result.remove(result.size() - 1);
        }
        return newResults;

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(new HashSet<>(Resursion(new LinkedList<>(), nums, 0)));

    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        System.out.println(new Solution90().subsetsWithDup(nums));

    }

}
