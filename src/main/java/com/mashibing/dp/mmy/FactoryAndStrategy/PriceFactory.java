package com.mashibing.dp.mmy.FactoryAndStrategy;

import java.util.ArrayList;
import java.util.List;

public class PriceFactory {
    private static final List<Class<? extends Discount>> disstrs = new ArrayList<>();

    static {
        disstrs.add(OrdinaryUserDis.class);
        disstrs.add(SilverUserDis.class);
        disstrs.add(GoldUserDis.class);
    }

    public static Discount getDiscountStrategy(double totalPrice) {
        for (Class<? extends Discount> clazz : disstrs) {
            StrategyAnnotation annotation = clazz.getAnnotation(StrategyAnnotation.class);
            if (totalPrice >= annotation.min() && totalPrice < annotation.max()) {
                try {
                    return clazz.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return new GoldUserDis();
    }
}
