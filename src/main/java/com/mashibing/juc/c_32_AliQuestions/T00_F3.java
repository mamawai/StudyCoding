package com.mashibing.juc.c_32_AliQuestions;


import com.mashibing.util.SleepHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 最原始的方法 Thread run() 重写
 */

public class T00_F3 {

    private static class Boss extends Thread{
        private List<Worker> tasks = new ArrayList<>();

        public void addTask(Worker t){
            tasks.add(t);
        }
        @Override
        public void run() {
            tasks.stream().forEach(t->t.start());
        }
        //取消了监视 变成了通知
        public void end(Worker worker){
            if (worker.getResult() == Result.FAILED){
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Boss boss = new Boss();
        Worker t1 = new Worker(boss, "t1", 30, true);
        Worker t2 = new Worker(boss, "t2", 50, true);
        Worker t3 = new Worker(boss, "t3", 1, false);


        boss.addTask(t1);
        boss.addTask(t2);
        boss.addTask(t3);

        boss.start();
        System.in.read();

    }
    private static enum Result{
        NOEND,SUCCESSED,FAILED
    }
    private static class Worker extends Thread{
        private Result result = Result.NOEND;

        private Boss boss;
        private String name;
        private int time;
        private boolean success;
        public Worker(Boss boss,String name,int time,boolean success){
            this.boss=boss;
            this.name=name;
            this.time=time;
            this.success=success;
        }
        public Result getResult(){
            return this.result;
        }

        @Override
        public void run() {
            SleepHelper.sleepSeconds(time);
            System.out.println(name + "任务结束");
            result = success ? Result.SUCCESSED: Result.FAILED;
            boss.end(this);
        }
    }


}
