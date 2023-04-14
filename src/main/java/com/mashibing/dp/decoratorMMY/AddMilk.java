package com.mashibing.dp.decoratorMMY;

public class AddMilk extends Decorator{

    protected Milk milk;

    public AddMilk(Beverage beverage) {
        super(beverage);
        this.milk = Milk.getInstance();
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ milk.getDescription();
    }

    @Override
    public int getCost() {
        return super.getCost()+milk.getCost();
    }
}
