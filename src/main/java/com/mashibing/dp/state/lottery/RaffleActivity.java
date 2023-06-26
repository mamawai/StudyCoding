package com.mashibing.dp.state.lottery;

public class RaffleActivity {
    // 活动当前状态
    State state;
    // 奖品数量
    int count;
    State noRaffleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);
    State dispenseState = new DispenseState(this);
    State dispenseOutState = new DispenseOutState(this);
    public RaffleActivity(int count){
        this.state = getNoRaffleState();
        this.count = count;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }
    public State getNoRaffleState() {
        return noRaffleState;
    }
    public State getDispenseState() {
        return dispenseState;
    }
    public State getDispenseOutState() {
        return dispenseOutState;
    }
    public void deductMoney(){
        state.deductMoney();
    }
    public void raffle(){
        if (state.raffle()){
            state.dispensePrize();
        }
    }

    public void setCount(int count) {
        this.count = count;
    }
}
