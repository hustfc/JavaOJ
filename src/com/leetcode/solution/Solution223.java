package com.leetcode.solution;

import javafx.util.Pair;

/**
 * @Author : fanc
 * @Date : 2020/6/20 6:58 下午
 */
public class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        // 首先判断不可能重合的情况
        if (E > C || G < A || F > D || H < B) {
            return area1 + area2;
        }
        // 如果重合，判断上下左右的坐标
        int up = Math.min(D, H);
        int down = Math.max(F, B);
        int left = Math.max(E, A);
        int right = Math.min(C, G);
        return area1 + area2 - (right - left) * (up - down);
    }
}
