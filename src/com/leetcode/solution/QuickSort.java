package com.leetcode.solution;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arrays, int start, int end) {
        if (arrays.length == 0 || start >= end) return;
        int low = start, high = end;
        int pivot = arrays[low];
        while (low < high) {
            while (low < high && arrays[high] >= pivot) {
                high --;
            }
            arrays[low] = arrays[high];
            while (low < high && arrays[low] <= pivot) {
                low ++;
            }
            arrays[high] = arrays[low];
        }
        arrays[low] = pivot;
        quickSort(arrays, start, low - 1);
        quickSort(arrays, low + 1, end);

    }

    public static void main(String[] args) {
        int[] arrays = {5,6,2,3,7,18,12,9,0};
        quickSort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }
}
