package com.mashibing.dp.state.lottery;

public class DispenseState implements State{
    RaffleActivity activity;
    public DispenseState(RaffleActivity activity){
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("不能扣积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (activity.getCount()>0){
            activity.setCount(activity.getCount()-1);
            System.out.println("给你奖品");
            activity.setState(activity.getNoRaffleState());
        }else {
            System.out.println("奖品被发完了");
            activity.setState(activity.getDispenseOutState());
        }
    }
}
