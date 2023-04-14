package com.mashibing.juc;

import com.mashibing.Application;
import com.mashibing.juc.c_32_AliQuestions.ITestClass;
import com.mashibing.juc.c_32_AliQuestions.TestClass;
import com.mashibing.util.SleepHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

@EnableAsync
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RunThread extends Thread {

    @Autowired
    ITestClass iTestClass;
    @Autowired
    ThreadPoolTaskExecutor pool;

    CountDownLatch countDownLatch = null;

    @Test
    public void TestThread() throws InterruptedException {

        countDownLatch = new CountDownLatch(1);

        System.out.println("dsadsa " + currentThread().getName());
        iTestClass.method();
        iTestClass.ss(countDownLatch);
        CompletableFuture<Integer> i = CompletableFuture.supplyAsync(() -> {
                    SleepHelper.sleepMilli(100);
                    return iTestClass.backInt(10);
                }).
                thenCompose(t -> CompletableFuture.supplyAsync(() -> {
                    SleepHelper.sleepMilli(100);
                    return iTestClass.backInt(33 + t);
                })).
                thenCombine(CompletableFuture.supplyAsync(() -> {
                    SleepHelper.sleepMilli(5000);;
                    return iTestClass.backInt(9);
                }), (integer1, integer2) -> integer1 * integer2);

        System.out.println(i.join());

        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return iTestClass.backString("aa");
        }).thenApply((result) -> result + "bb").thenApplyAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            return iTestClass.backString(result + "cc");
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return iTestClass.backString("xx");
        }, pool).thenApply((result) -> result + "yy").thenApplyAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            return iTestClass.backString(result + "zz");
        }, pool);

//        countDownLatch.await();
        System.out.println("dsada " + currentThread().getName());
    }

    @Test
    public void phoneTest() {
        //applyToEither两个线程同时进行谁先结束get到谁的值
        CompletableFuture<String> pickupOrNotp = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int i = random.nextInt(1200);
            SleepHelper.sleepMilli(i);
            System.out.println(Thread.currentThread());
            return "电话经过了在60秒内被";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            SleepHelper.sleepMilli(600);
            System.out.println(Thread.currentThread());
            return "电话经过了60s无人接听";
        }), pickupOrNot -> {
            if (pickupOrNot.equals("电话经过了60s无人接听"))
                throw new RuntimeException("没人接听");
            else
                return pickupOrNot + "接听啦";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            System.out.println(Thread.currentThread());
            return "重新拨打了电话";
        });
        System.out.println(pickupOrNotp.join());
    }
}
