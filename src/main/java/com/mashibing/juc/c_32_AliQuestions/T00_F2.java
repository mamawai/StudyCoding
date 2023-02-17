package com.mashibing.juc.c_32_AliQuestions;

import com.mashibing.util.SleepHelper;

import java.util.ArrayList;
import java.util.List;
/**
 * 分布式事务ABC 若一个出错则全部取消，要求效率高，当t3失败就立即退出，不用等t1 t2
 */
public class T00_F2 {
    //监视版本
    public static void main(String[] args) {
        MyTask t1 = new MyTask("t1", 30, true);
        MyTask t2 = new MyTask("t2", 80, true);
        MyTask t3 = new MyTask("t3", 1, false);

        List<MyTask> tasks = new ArrayList<>();
        tasks.add(t1);tasks.add(t2);tasks.add(t3);

        //启动线程
        tasks.stream().forEach(t->t.start());

        //启动监视(忙等待不好，消耗资源)
        for (;;){
            for (MyTask task:tasks){
                if (task.getResult() == Result.FAILED){
                    //暴力推出 不建议
                    System.exit(0);
                }
            }
        }

    }
    private static enum Result{
        NOEND,SUCCESSED,FAILED
    }
    private static class MyTask extends Thread{
        private Result result = Result.NOEND;
        private String name;
        private int time;
        private boolean success;
    public MyTask(String name,int time,boolean success){
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
            result = success ? Result.SUCCESSED:Result.FAILED;
        }
    }

}
