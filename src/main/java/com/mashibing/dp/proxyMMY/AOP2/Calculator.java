package com.mashibing.dp.proxyMMY.AOP2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Calculator {
        int add(int a, int b);
        }

interface Printer {
    void print(String message);
}

class CalculatorPrinterImpl implements Calculator, Printer {
    @Override
    public int add(int a, int b) {
        int result = a + b;
        print("The sum is: " + result);
        return result;
    }

    @Override
    public void print(String message) {
        System.out.println("Printing: " + message);
    }
}

class MultiInterfaceInvocationHandler implements InvocationHandler {
    private Object target;

    public MultiInterfaceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        if (method.getName().equals("add")) {
            print("Calculation completed");
        }
        return result;
    }

    private void print(String message) {
        Printer printer = (Printer) target;
        printer.print(message);
    }
}

class Main {
    public static void main(String[] args) {
        CalculatorPrinterImpl calculatorPrinter = new CalculatorPrinterImpl();
        MultiInterfaceInvocationHandler invocationHandler = new MultiInterfaceInvocationHandler(calculatorPrinter);

        Class<?>[]  interfaces = new Class[]{Calculator.class, Printer.class};

        Object proxy = Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                interfaces,
                invocationHandler
        );

        Calculator calculatorProxy = (Calculator) proxy;
        calculatorProxy.add(2, 3);
    }
}