package com.mashibing.dp.state.lottery;

public class Client {
    public static void main(String[] args) {
        RaffleActivity raffleActivity = new RaffleActivity(1);
        for (int i = 0;i<30;i++) {
            raffleActivity.deductMoney();
            raffleActivity.raffle();
        }
    }
}
