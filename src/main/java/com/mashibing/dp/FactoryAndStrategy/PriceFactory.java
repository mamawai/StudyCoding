package com.mashibing.dp.FactoryAndStrategy;

import java.util.ArrayList;
import java.util.List;

public class PriceFactory {
    private static final List<Class<? extends Discount>> disList = new ArrayList<>();

    static {
        disList.add(OrdinaryUserDis.class);
        disList.add(SilverUserDis.class);
        disList.add(GoldUserDis.class);
    }

    public static Discount getDiscountStrategy(int index) {
        try {
            return disList.get(index).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
