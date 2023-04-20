package com.mashibing.dp.FactoryAndStrategy;

public interface Discount extends Filter{
    double Callprice(double price);

    static Discount getDisInstance(int index){
        return PriceFactory.getDiscountStrategy(index);
    }
}
