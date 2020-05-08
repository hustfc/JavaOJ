package com.leetcode.solution;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author : fanc
 * @Date : 2020/5/8 7:16 下午
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {

        /**
         * threshold = capacity * loadFactor，如果超过这个threshold之后就需要扩容
         * 第三个参数为true表示遵循LRU(last recently used, 最近最少使用)模式
         */
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * 官方注释
     * <tt>true</tt> if the eldest entry should be removed
     * from the map; <tt>false</tt> if it should be retained.
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}
