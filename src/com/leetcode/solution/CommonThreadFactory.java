package com.leetcode.solution;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonThreadFactory implements ThreadFactory {
    private AtomicInteger threadNum = new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName("common" + threadNum.incrementAndGet());
        return t;
    }
}
