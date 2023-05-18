package com.mashibing.dp.decoratorMMY;

public class AddSuger implements Beverage{

    protected Beverage beverage;

    public AddSuger(Beverage beverage) {
        this.beverage  = beverage;
    }

    @Override
    public String getDescription() {

        return beverage.getDescription() + " 加了一份Sugar";
    }

    @Override
    public int getCost() {
        return beverage.getCost() + 1;
    }
}
