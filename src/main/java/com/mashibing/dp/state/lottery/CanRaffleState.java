package com.mashibing.dp.state.lottery;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Random;

public class CanRaffleState implements State{
    RaffleActivity activity;
    public CanRaffleState(RaffleActivity activity){
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("已经扣过积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖请稍等");
        Random random = new Random();
        int num = random.nextInt(10);
        if (num == 0){
            activity.setState(activity.getDispenseState());
            System.out.println("抽中了");
            return true;
        }else {
            System.out.println("没抽中");
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        System.out.println("没中奖，不能发放奖品呢");
    }
}
