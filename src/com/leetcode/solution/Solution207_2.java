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
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
//        System.out.println(inDegree[0]);
//        System.out.println(inDegree[1]);
        while (!queue.isEmpty()) {
            int finishCourse = queue.removeFirst();
            numCourses -= 1;
            for (int course : courseList.get(finishCourse)) {
                if (--inDegree[course] == 0) {
                    queue.add(course);
                }
            }
        }
        return numCourses == 0;


    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[0][0];
        System.out.println(new Solution207().canFinish(2, prerequisites));
    }
}
