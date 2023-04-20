package com.mashibing.dp.FactoryAndStrategy;

import java.util.Arrays;
import java.util.function.Consumer;

//解决方法
public class Settlement {
    MoneyChain moneyChain = new MoneyChain();
    private double totalSpend = 0;
    //Settlement 内消耗的策略类实例，正好由工厂类来提
    public Settlement buy(double amount){

        String responseMoney = "";
        // 分段计算每个level返回的钱数
        String ResponseMoneyString = moneyChain.proceed(new RequestMoney(amount,totalSpend), responseMoney);
        // Gold,Silver,Ordinary
        System.out.println(ResponseMoneyString);

        ResponseMoneyString = InsertZero(ResponseMoneyString);
        System.out.println(ResponseMoneyString);

        String[] moneySplit = ResponseMoneyString.split(",");

        for(int j = 0; j<moneySplit.length;j++){
            // 工厂生成实例，策略模式消耗（使用）实例
            double call = Discount.getDisInstance(j).Callprice(new Double(moneySplit[j]));
            this.totalSpend += call;
        }
        System.out.println(totalSpend);
        // 重置index
        moneyChain.index = 0;
        return this;

    }

    public String InsertZero(String ResponseMoneyString) {
        char[] charArray = ResponseMoneyString.toCharArray();

        for (int i = 0,j=0; i< charArray.length;i++,j++){
            if (charArray[i] == ',' && (i == 0 || !Character.isDigit(charArray[i-1]))){
                ResponseMoneyString = ResponseMoneyString.substring(0,j) + "0" + ResponseMoneyString.substring(j);
                j++;
            }
        }
        return ResponseMoneyString;
    }

    public void setTotalSpend(double totalSpend) {
        this.totalSpend = totalSpend;
    }

    public double getTotalSpend(){
        return totalSpend;
    }
}
