package com.leetcode.solution;


public class Seller {
    private static Worker worker = new Worker();

    private static void sell() {
        System.out.println("开始销售机器");
    }

    public static void main(String[] args) {
        //实现回调接口，将售卖方法放在回调接口里面
        worker.setWorkerListner(num -> {
            System.out.println("现在已经生产完成" + num + "台机器");
            if(num == 100) {
                sell();
            }
        });

        worker.MakeMachine();
    }

}
