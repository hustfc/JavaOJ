package com.leetcode.solution;


import java.util.Hashtable;

/**
 * @Author : fanc
 * @Date : 2020/5/8 8:51 下午
 */
public class MyLRUCache {
    /**
     * 与LinkedHashMap的实现差不多
     * value为双指针链表，每次插入到头部，每次从最尾部删除
     */
    private Hashtable<Integer, DListNode> cache = new Hashtable<>();
    DListNode head;
    DListNode tail;
    int size;
    int capacity;

    private class DListNode {
        int key;
        int value;
        DListNode prev;
        DListNode next;


        DListNode(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    /**
     * 在head后面添加node
     * @param node
     */
    private void addNode(DListNode node) {
        DListNode headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    /**
     * 删除node，不一定是在最后面删除
     * @param node
     */
    private void remove(DListNode node) {
        DListNode nodePrev = node.prev;
        DListNode nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
    }

    /**
     * 遍历之后，移动到最开头
     * @param node
     */
    private void moveToFirst(DListNode node) {
        remove(node);
        addNode(node);
    }

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DListNode(-1, -1);
        tail = new DListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        DListNode node = cache.get(key);
        // 这个时候size不变
        if (node != null) {
            node.value = value;
            moveToFirst(node);
        }
        else {
            DListNode newNode = new DListNode(key, value);
            // 在等于的时候插入一个，就已经需要移除了
            if (size >= capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
                // 因为最后要统一加上，所以这个地方size先减1才能保持不变
                size -= 1;
            }
            addNode(newNode);
            cache.put(key, newNode);
            size += 1;
        }
    }
}
