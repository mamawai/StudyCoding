package com.mashibing.juc.c_32_AliQuestions;


import com.mashibing.util.SleepHelper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 最原始的方法 Thread run() 重写
 */

public class T00_F3 {

    static Logger logger = Logger.getLogger(T00_F3.class);
    private static class Boss extends Thread{
        private List<Worker> workers = new ArrayList<>();

        public void addTask(Worker t){
            workers.add(t);
        }
        @Override
        public void run() {
            workers.stream().forEach(t->t.start());
        }
        //取消了监视 变成了通知
        public void end(Worker worker){
            if (worker.getResult() == Result.FAILED){
                logger.info(worker.name+" 任务失败");
                /*System.exit(0);*///退出不优雅
                cancel(worker);
            }
        }
        private void cancel(Worker worker){
            for (Worker w : workers){
                if (w != worker){
                    w.cancel();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Boss boss = new Boss();
        Worker t1 = new Worker(boss, "t1", 3, true);
        Worker t2 = new Worker(boss, "t2", 7, true);
        Worker t3 = new Worker(boss, "t3", 1, false);


        boss.addTask(t1);
        boss.addTask(t2);
        boss.addTask(t3);

        boss.start();
        System.in.read();

    }
    private static enum Result{
        NOEND,SUCCESSED,FAILED,CANCELLED
    }
    private static class Worker extends Thread{
        private Result result = Result.NOEND;
        private volatile  boolean cancelling = false;

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
            int interval = 100;
            int total = 0;

            for (;;) {
                SleepHelper.sleepMilli(interval);
                total+=interval;
                if (total/1000>=time) {
                    result = success ? Result.SUCCESSED: Result.FAILED;
                    if (result == Result.SUCCESSED) {
                        System.out.println(name + "任务结束");
                    }
                    break;
                }
                if (cancelling){
                    rollback();
                    result = Result.CANCELLED;
                    cancelling = false;
                    logger.info(name+"任务结束"+result);
                    break;
                }
            }
            boss.end(this);
        }
        private  void rollback(){
            logger.info(name+" rollback start...");
            SleepHelper.sleepMilli(500);
            logger.info(name+" rollback end...");
        }
        public void cancel(){
            cancelling =true;
        }
    }


}
