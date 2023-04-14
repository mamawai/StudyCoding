package com.mashibing.dp.decoratorMMY;

public class Decorator implements Beverage{

    protected Beverage beverage;

    public Decorator(Beverage beverage) {
        this.beverage  = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public int getCost() {
        return beverage.getCost();
    }
}
