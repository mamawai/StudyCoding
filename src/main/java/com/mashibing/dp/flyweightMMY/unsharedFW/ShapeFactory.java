package com.mashibing.dp.flyweightMMY.unsharedFW;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>();

    // 获取共享具体享元对象
    public static Shape getCircle(String color, String borderStyle) {
        String key = color + borderStyle;
        Shape circle = circleMap.get(key);

        if (circle == null) {
            circle = new Circle(color, borderStyle);
            circleMap.put(key, circle);
        }

        return circle;
    }

    // 获取非共享具体享元对象
    public static Shape getCustomCircle(String color, String borderStyle, int x, int y, int radius) {
        Circle circle = new Circle(color, borderStyle);
        circle.setX(x);
        circle.setY(y);
        circle.setRadius(radius);

        return circle;
    }
}
