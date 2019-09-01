package com.leetcode.solution;

public class Worker {
    private WorkerListner workerListner;

    public void MakeMachine(){
        for(int num = 0; num <= 100; num ++) {
            //调用接口通知监听者
            workerListner.onWorkerListner(num);
        }
    }

    public interface WorkerListner {
        //回调接口，销售的操作需要实现这个接口
        void onWorkerListner(int num);
    }

    public void setWorkerListner(WorkerListner workerListner) {
        this.workerListner = workerListner;
    }
}
