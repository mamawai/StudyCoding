package com.mashibing.dp.FactoryAndStrategy;

import java.util.ArrayList;
import java.util.List;

public class MoneyChain {
    List<Discount> moneyLevel = new ArrayList<>();
    int index = 0;
    public MoneyChain(){
        moneyLevel.add(new OrdinaryUserDis());
        moneyLevel.add(new SilverUserDis());
        moneyLevel.add(new GoldUserDis());
    }

    public String proceed(RequestMoney requestMoney,String responseMoney){
        if (index == moneyLevel.size()) return "";
        Discount discountLevel = moneyLevel.get(index);
        index++;

        return discountLevel.FilterMoney(requestMoney, responseMoney, this);
    }
}
