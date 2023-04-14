package com.mashibing.dp.mmy.FactoryAndStrategy;

public class Main {
    public static void main(String[] args) {
        Settlement settlement = new Settlement();
        settlement.buy(5000);settlement.buy(5000);settlement.buy(5000);
        settlement.buy(5000);settlement.buy(5000);settlement.buy(5000);
        double buy = settlement.buy(5000);
        System.out.println(buy);
        System.out.println(settlement.getTotalSpend());
    }
}
