package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/6/11 5:05 下午
 */
public class Solution207_2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courseList = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            courseList.add(new LinkedList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            courseList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]] += 1;
        }
        LinkedList<Integer> queue = new LinkedList<>();

        // 这里注意一个bug，循环终止条件numCourses已经变化
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                // 这里注意一个bug，循环终止条件numCourses已经变化，所以这个时候不要更改numCourses
                // numCourses -= 1;
            }
        }
        while (!queue.isEmpty()) {
            int finishCourse = queue.removeFirst();
            numCourses -= 1;
            for (int course : courseList.get(finishCourse)) {
                if (--inDegree[course] == 0) {
                    queue.add(course);
                }
            }
        }
        System.out.println(numCourses);
        return numCourses == 0;


    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[0][0];
        System.out.println(new Solution207_2().canFinish(2, prerequisites));
    }
}
