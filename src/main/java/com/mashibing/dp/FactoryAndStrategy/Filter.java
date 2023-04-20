package com.mashibing.dp.FactoryAndStrategy;

public interface Filter {
    String FilterMoney(RequestMoney requestMoney, String responseMoney, MoneyChain moneyChain);
}
