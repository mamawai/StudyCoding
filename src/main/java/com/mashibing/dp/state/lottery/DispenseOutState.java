package com.mashibing.dp.state.lottery;

public class DispenseOutState implements State{
    RaffleActivity activity;
    public DispenseOutState(RaffleActivity activity){
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("奖品发完了请下次参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发完了请下次参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发完了请下次参加");
    }
}
