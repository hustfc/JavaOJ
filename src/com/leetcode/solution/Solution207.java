package com.leetcode.solution;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2020/6/11 10:49 上午
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 存放对应的课程关系
        Map<Integer, List<Integer>> coursesMap = new HashMap<>();

        // 存放每个课程是否可以完成
        Boolean[] courseList = new Boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courseList[i] = false;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            List<Integer> list;
            if (coursesMap.containsKey(course)) {
                list = coursesMap.get(course);
            } else {
                list = new LinkedList<>();
                coursesMap.put(course, list);
            }
            list.add(prerequisites[i][1]);
        }

        for (int i = 0, j = 0; i < numCourses && j < 2; i++) {
            List<Integer> list = coursesMap.getOrDefault(i, new LinkedList<>());
            if (list.size() == 0) {
                courseList[i] = true;
            }
            for (Integer course : list) {
                // 一个课程可能依赖很多课程，这些课程必须全部修完
                if (!courseList[course]) {
                    break;
                }
            }
            courseList[i] = true;
            // 循环完了之后i还需要加1
            if (i == numCourses - 1) {
                i = -1;
                j += 1;
            }
        }

        for (Boolean course : courseList) {
            if (!course) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{0, 1}, {0, 2}, {1, 0}};
        System.out.println(new Solution207().canFinish(3, prerequisites));
    }
}
