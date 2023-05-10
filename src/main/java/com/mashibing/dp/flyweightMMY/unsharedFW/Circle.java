package com.mashibing.dp.flyweightMMY.unsharedFW;

// 具体享元类 - 圆形
public class Circle implements Shape{
    // 共享属性
    private String color;
    private String borderStyle;

    // 非共享属性
    private int x;
    private int y;
    private int radius;

    public Circle(String color, String borderStyle) {
        this.color = color;
        this.borderStyle = borderStyle;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                + ", Border Style : " + borderStyle
                + ", x : " + x + ", y :" + y
                + ", radius :" + radius);
    }

    public void draw(GoodOrBad goodOrBad){
        System.out.println("Circle: Draw() [Color : " + color
                + ", Border Style : " + borderStyle
                + ", x : " + x + ", y :" + y
                + ", radius :" + radius + " " + goodOrBad.getGB());
    }
}
