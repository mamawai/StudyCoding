package com.mashibing.juc.c_32_AliQuestions;

import com.mashibing.util.SleepHelper;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.EnableAsync;

public class T06_03_AliQust {


    static Logger logger = Logger.getLogger(T06_03_AliQust.class);
    //任务执行的三种状态
    private static enum Result{
        SUCCESS,FAILED,CANCELLED
    }
    static List<MyTask> tasks = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        MyTask task1 = new MyTask("task1",3,Result.SUCCESS);
        MyTask task2 = new MyTask("task2",4,Result.SUCCESS);
        MyTask task3 = new MyTask("task3",1,Result.FAILED);


        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        for (MyTask task : tasks){
            CompletableFuture f = CompletableFuture.supplyAsync(()->task.runTask()).thenAccept((result)-> callback(result,task));
        }
        logger.info("主线程正常执行");
        TimeUnit.SECONDS.sleep(10);
    }
    private static Result callback(Result result,MyTask task){
        if (Result.FAILED == result){
            for (MyTask _task: tasks){
                if (_task != task){
                    _task.cancel();
                }
            }
        }
        return result;
    }

    private static class MyTask{
        private String name;
        private int time;
        private Result ret;
        boolean cancelling = false;
        volatile boolean cancelled = false;

        public MyTask(String name, int time, Result ret) {
            this.name = name;
            this.time = time;
            this.ret = ret;
        }
        public Result runTask(){
            int interval = 100;
            int total = 0;

            for (;;){
                try {
                    Thread.sleep(interval);
                    if (cancelling) continue;
                    total+=interval;
                    if(total >= time) break;
                    if (cancelled) return Result.CANCELLED;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            logger.info(name + " end!");
            return ret;
        }
        public void cancel(){
            cancelling = true;
            synchronized (this){
                System.out.println(name + "cancelling");
                SleepHelper.sleepMilli(50);
                System.out.println(name +"cancelled");
            }
            cancelled = true;
        }
    }
}
