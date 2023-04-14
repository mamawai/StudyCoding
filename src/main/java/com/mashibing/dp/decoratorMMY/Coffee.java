package com.mashibing.dp.decoratorMMY;


public abstract class Coffee implements Beverage{

}

class Black extends Coffee{

    @Override
    public String getDescription() {
        return "美式黑咖啡";
    }

    @Override
    public int getCost() {
        return 20;
    }
}

class Latte extends Coffee{

    @Override
    public String getDescription() {
        return "拿铁咖啡";
    }

    @Override
    public int getCost() {
        return 25;
    }
}
