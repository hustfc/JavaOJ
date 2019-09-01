package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2019-08-12 19:37
 */
public class Mythread2 implements Runnable{
    private int count = 15;
    @Override
    public void run() {
        for(int i = 0; i < 5; i ++) {
            System.out.println(Thread.currentThread().getName() + " count = " + count --);
            try {
                Thread.sleep((int)Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Mythread2 mythread2 = new Mythread2();
        new Thread(mythread2, "A").start();
        new Thread(mythread2, "B").start();
        new Thread(mythread2, "C").start();
    }
}
