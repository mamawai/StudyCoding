package com.mashibing.juc.c_32_AliQuestions;


import java.util.concurrent.CountDownLatch;

public interface ITestClass {
    void method();

    void ss(CountDownLatch countDownLatch);

    Integer backInt(Integer integer);

    String backString(String s);
}
