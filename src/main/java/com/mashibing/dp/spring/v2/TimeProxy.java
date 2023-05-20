package com.mashibing.dp.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TimeProxy {

    @Pointcut("execution (void com.mashibing.dp.spring.v2.Tank.move())")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("method start.." + System.currentTimeMillis());
    }

    @After("pointcut()")
    public void after() {
        System.out.println("method stop.." + System.currentTimeMillis());
    }

}
