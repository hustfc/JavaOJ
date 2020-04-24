package com.leetcode.solution;

import java.util.List;

/**
 * @Author : fanc
 * @Date : 2020/4/24 10:21 下午
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        for (int i = triangle.size() - 2; i >= 0; i --) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                // 如果是从下至上遍历的话，不需要考虑边界情况了
                triangle.get(i).set(j, triangle.get(i).get(j) +
                        Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));

            }
        }
        return triangle.get(0).get(0);
    }
}
