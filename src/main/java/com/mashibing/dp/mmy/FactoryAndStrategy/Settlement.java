package com.mashibing.dp.mmy.FactoryAndStrategy;

//解决方法
public class Settlement {
    private double amount;
    private double totalPrice,totalSpend = 0;
    //Settlement 内消耗的策略类实例，正好由工厂类来提供
    //private Discount discount;
    public Settlement buy(double amount){
        this.amount = amount;
        this.totalPrice += amount;
        // getDisInstance工厂获取实例---打哪种折扣?;再使用这种折扣实例调用Callprice,"消耗掉实例"
        double call = Discount.getDisInstance(totalPrice).Callprice(amount);
        System.out.println(call);
        this.totalSpend += call;
        return this;
        /*double callprice = PriceFactory.getDiscountStrategy(totalPrice).Callprice(amount);
        this.totalSpend += callprice;
        return callprice;*/
    }
    public double getTotalSpend(){
        return totalSpend;
    }
}
