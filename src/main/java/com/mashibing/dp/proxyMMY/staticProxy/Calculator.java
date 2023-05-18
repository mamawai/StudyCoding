package com.mashibing.dp.proxyMMY.staticProxy;

import com.mashibing.dp.MonitorUtil;
import org.apache.tomcat.jni.Time;

// 接口
interface Calculator {
    int add(int a, int b);
}
// 实现类
class CalculatorImpl implements Calculator{

    @Override
    public int add(int a, int b) {
        System.out.println("Do add method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a + b;
    }
}
// 代理类
class CalculatorLogProxy implements Calculator{
    // 持有Calculator引用
    private Calculator calculator;
    public CalculatorLogProxy(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public int add(int a, int b) {
        System.out.println("Before invoking add method");
        int result = calculator.add(a, b);
        System.out.println("After invoking add method");
        return result;
    }
}
class CalculatorTimeProxy implements Calculator{
    private Calculator calculator;
    public CalculatorTimeProxy(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public int add(int a, int b) {
        MonitorUtil.start();
        int result = calculator.add(a, b);
        MonitorUtil.finish("add");
        return result;
    }
}
// 测试
class Client{
    public static void main(String[] args) {
        Calculator proxy = new CalculatorTimeProxy(new CalculatorLogProxy(new CalculatorImpl()));
        int result = proxy.add(2, 4);
        System.out.println("Result: "+result);
    }
}