package com.mashibing.dp.FactoryAndStrategy;

public class Main {
    public static void main(String[] args) {
        Settlement settlement = new Settlement();
        settlement.setTotalSpend(5000.0);
        double totalSpend = settlement.buy(18787.0)
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
