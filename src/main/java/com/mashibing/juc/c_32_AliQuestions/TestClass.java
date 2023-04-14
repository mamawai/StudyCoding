package com.mashibing.juc.c_32_AliQuestions;


import com.mashibing.util.SleepHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class TestClass extends Thread implements ITestClass {

//    private CountDownLatch countDownLatch;
//
//    public TestClass(CountDownLatch countDownLatch) {
//        this.countDownLatch = countDownLatch;
//    }
//    public TestClass(){
//
//    }

    @Async("APool")
    public void method() {
        for (int i = 0; i < 5; i++) {
            SleepHelper.sleepMilli(500);
            System.out.println(currentThread().getName());
            System.out.println("i:" + i);
        }
    }

    @Async
    public void ss(CountDownLatch countDownLatch) {
        SleepHelper.sleepSeconds(10);
        System.out.println("异步线程interrupt10s：" + currentThread().getName());
        countDownLatch.countDown();
    }

    public Integer backInt(Integer integer) {
        System.out.println("异步线程：" + currentThread().getName() + "当前操作数：" + integer);
        return integer;
    }

    public String backString(String s) {
        System.out.println("异步线程：" + currentThread().getName() + "当前操作数：" + s);
        return s;
    }
}
