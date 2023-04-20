package com.mashibing.dp.FactoryAndStrategy;

@StrategyAnnotation(max = 20000,min = 10000)
public class SilverUserDis implements Discount ,Filter{
    @Override
    public double Callprice(double price) {

        return 0.9 * price;
    }

    @Override
    public String FilterMoney(RequestMoney requestMoney, String responseMoney, MoneyChain moneyChain) {
        StrategyAnnotation annotationS = SilverUserDis.class.getAnnotation(StrategyAnnotation.class);

        if (requestMoney.getAll() > annotationS.max()){
            String proceed = moneyChain.proceed(requestMoney, responseMoney);
            if (requestMoney.getHistorySpend() >= annotationS.max()){
                return "," + proceed;
            }else {
                return  "," + (annotationS.max() - requestMoney.getHistorySpend()) + "," + proceed;
            }
        }else {
            if (requestMoney.getHistorySpend() >= annotationS.min()){
                return responseMoney + "," + requestMoney.getAmount() + ",";
            }
            else {
                return responseMoney + "," + (requestMoney.getAll() - annotationS.min()) + ",";
            }
        }
    }
}
