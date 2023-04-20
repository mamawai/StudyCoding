package com.mashibing.dp.FactoryAndStrategy;

@StrategyAnnotation(max = 30000,min =20000)
public class GoldUserDis implements Discount,Filter {
    @Override
    public double Callprice(double price) {

        return 0.75*price;
    }

    @Override
    public String FilterMoney(RequestMoney requestMoney, String responseMoney, MoneyChain moneyChain) {
        StrategyAnnotation annotationG = GoldUserDis.class.getAnnotation(StrategyAnnotation.class);

        moneyChain.proceed(requestMoney,responseMoney);

        if (requestMoney.getHistorySpend() >= annotationG.min()) {
            return responseMoney + (requestMoney.getAmount() + ",");
        }else {
            return responseMoney + (requestMoney.getAll()-annotationG.min()+",");
        }
    }
}
