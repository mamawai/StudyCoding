package com.mashibing.dp.mmy.FactoryAndStrategy;

public class Main {
    public static void main(String[] args) {
        Settlement settlement = new Settlement();
        double totalSpend = settlement.buy(50000)
                .buy(5000)
                .buy(5000)
                .buy(5000)
                .buy(5000)
                .buy(5000)
                .buy(5000).getTotalSpend();
//        double buy = settlement.buy(5000);
//        System.out.println(buy);
        System.out.println(totalSpend);
    }
}
