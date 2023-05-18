package com.mashibing.dp.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * CGLIB实现动态代理不需要接口
 */
public class Main {
    public static void main(String[] args) {
        Callback[] callbacks = new Callback[] {
                new TimeMethodInterceptor(), new LogMethodInterceptor()
        };

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(new CallBackFilterImpl());
        Tank tank = (Tank)enhancer.create();
        tank.move();
        tank.shot();
    }
}

class TimeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("before");
        Object result = null;
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return result;
    }
}

class LogMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        method.invoke(new Tank(),objects);
        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("Log before");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("Log after");
        return result;

    }
}

class CallBackFilterImpl implements CallbackFilter{

    @Override
    public int accept(Method method) {
        if (method.getName().equals("shot")){
            return 1;
        }
        else {
            return 0;
        }
    }
}
class Tank {
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void shot(){
        System.out.println("Tank shot biubiubiu...");
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


