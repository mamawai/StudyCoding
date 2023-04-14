package com.mashibing.dp.mmy.FactoryAndStrategy;

@StrategyAnnotation(max = 20000,min = 10000)
public class SilverUserDis implements Discount{
    @Override
    public double Callprice(double price) {

        return 0.9 * price;
    }
}
