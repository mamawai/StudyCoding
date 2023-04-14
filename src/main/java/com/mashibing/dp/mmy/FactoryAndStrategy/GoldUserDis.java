package com.mashibing.dp.mmy.FactoryAndStrategy;

@StrategyAnnotation(max = 30000,min =20000)
public class GoldUserDis implements Discount{
    @Override
    public double Callprice(double price) {

        return 0.75*price;
    }
}
