package com.mashibing.dp.mmy.FactoryAndStrategy;

//解决方法
public class Settlement {
    private double amount;
    private double totalPrice,totalSpend = 0;
    //策略类消耗的实例，正好有工厂类提供
    //private Discount discount;
    public double buy(double amount){
        this.amount = amount;
        this.totalPrice += amount;
        double call = Discount.getDisInstance(totalPrice).Callprice(amount);
        this.totalSpend += call;
        return call;
        /*double callprice = PriceFactory.getDiscountStrategy(totalPrice).Callprice(amount);
        this.totalSpend += callprice;
        return callprice;*/
    }
    public double getTotalSpend(){
        return totalSpend;
    }
}
