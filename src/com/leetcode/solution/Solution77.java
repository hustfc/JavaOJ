package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2019-09-01 19:25
 */
public class Solution77 {
    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;

    public void traceback(int first, LinkedList<Integer> current) {
        if (current.size() == k) {
            //错误，不能直接加上current，否则所有的元素都是一个引用
            //output.add(current);
            output.add(new LinkedList<Integer>(current));
            System.out.println(output);
            return;
        }

        for (int i = first; i <= n; i ++) {
            //保存回溯结果
            //LinkedList<Integer> temp = new LinkedList<>(current);
            current.add(i);
            traceback(i + 1, current);
            //回溯：第一种方法current.removeLast()因为每一个add后面跟一个remove保证回溯
            //current = temp;
            current.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        traceback(1, new LinkedList<>());
        return output;
    }
}
