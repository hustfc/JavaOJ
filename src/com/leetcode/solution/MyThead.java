package com.leetcode.solution;

public class MyThead  extends Thread{
    private int count = 5;
    private String name;
    public MyThead(String name) {
        this.name = name;
    }
    public void run() {
        for(int i = 0; i < 5; i ++) {
            System.out.println("Thead: " + name + " count = " + count --);
        }
        try {
            sleep((int)Math.random() * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThead thread1 = new MyThead("A");
        MyThead thread2 = new MyThead("B");
        thread1.start();
        thread2.start();
    }
}
