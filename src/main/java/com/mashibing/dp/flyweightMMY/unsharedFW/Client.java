package com.mashibing.dp.flyweightMMY.unsharedFW;

public class Client {
    public static void main(String[] args) {
        // 获取共享具体享元对象
        Circle circle1 = (Circle) ShapeFactory.getCircle("red", "dotted");
        circle1.draw();
        circle1.draw(new GoodOrBad("good"));

        Shape circle2 = ShapeFactory.getCircle("blue", "dashed");
        circle2.draw();

        Circle circle3 = (Circle) ShapeFactory.getCircle("red", "dotted");
        circle3.draw();
        circle3.draw(new GoodOrBad("bad"));

        // 获取非共享具体享元对象
        Shape customCircle1 = ShapeFactory.getCustomCircle("green", "solid", 100, 100, 50);
        customCircle1.draw();

        Shape customCircle2 = ShapeFactory.getCustomCircle("green", "solid", 100, 100, 50);
        customCircle2.draw();

        System.out.println(circle1 == circle3);// true
        System.out.println(customCircle1 == customCircle2);// false




    }
}
