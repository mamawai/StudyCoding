package com.mashibing.dp.singleton;

import java.util.ArrayList;

public class TestE {

    public static void m() {
        ArrayList a = new ArrayList(10);
        ArrayList b = new ArrayList(8);
        a.add(b);
        System.out.println(b);
        System.out.println(a);
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Emperor instance = Emperor.getInstance(1);
        String info = instance.getInfo();
        System.out.println(info);
        System.out.println(instance.toString());
    }
}
