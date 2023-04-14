package com.mashibing.dp.decoratorMMY;

public class AddChoc extends Decorator{

    protected Chocolate chocolate;

    public AddChoc(Beverage beverage) {
        super(beverage);
        this.chocolate = Chocolate.getInstance();
    }

    @Override
    public String getDescription() {
        return super.getDescription()+chocolate.getDescription();
    }

    @Override
    public int getCost() {
        return super.getCost()+chocolate.getCost();
    }
}
