package com.mashibing.dp.state.lottery;
/**
 * 不能抽奖的状态
 */
public class NoRaffleState implements State{
    RaffleActivity activity;
    public NoRaffleState(RaffleActivity activity){
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分，您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品没有了不能发放奖品");
    }
}
