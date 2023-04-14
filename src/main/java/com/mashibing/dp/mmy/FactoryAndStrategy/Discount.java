package com.mashibing.dp.mmy.FactoryAndStrategy;

public interface Discount {
    double Callprice(double price);

    static Discount getDisInstance(double totalPrice){
        return PriceFactory.getDiscountStrategy(totalPrice);
    }
}
