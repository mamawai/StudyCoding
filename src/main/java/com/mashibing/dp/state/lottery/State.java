package com.mashibing.dp.state.lottery;

public interface State {
    // 扣除积分 -50
    void deductMoney();
    // 是否抽中奖品
    boolean raffle();
    // 发放奖品
    void dispensePrize();
}
