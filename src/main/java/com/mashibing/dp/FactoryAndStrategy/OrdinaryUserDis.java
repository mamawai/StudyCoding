package com.mashibing.dp.FactoryAndStrategy;

@StrategyAnnotation(max = 10000,min = 0)
public class OrdinaryUserDis implements Discount,Filter{
    @Override
    public double Callprice(double price) {
        return price;
    }

    @Override
    public String FilterMoney(RequestMoney requestMoney, String responseMoney, MoneyChain moneyChain) {
        StrategyAnnotation annotationO = OrdinaryUserDis.class.getAnnotation(StrategyAnnotation.class);
        if (requestMoney.getAll() > annotationO.max()){
            String proceed = moneyChain.proceed(requestMoney, responseMoney);
            if (requestMoney.getHistorySpend() >= annotationO.max()) {
                return "," + proceed;
            }else {
                return (annotationO.max() - requestMoney.getHistorySpend()) + proceed;
            }
        }else {
           return responseMoney + "," + "," + (requestMoney.getAmount() + ",");
        }
    }
}
