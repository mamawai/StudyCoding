package com.mashibing.dp.mmy.FactoryAndStrategy;

@StrategyAnnotation(max = 10000,min = 0)
public class OrdinaryUserDis implements Discount{
    @Override
    public double Callprice(double price) {
        return price;
    }
}
