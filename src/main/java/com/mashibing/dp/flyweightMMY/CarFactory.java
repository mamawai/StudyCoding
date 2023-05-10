package com.mashibing.dp.flyweightMMY;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {
    private static Map<String,Car> carMap = new HashMap<>();
    public static Car getCar(String model){
        Car car = carMap.get(model);
        if (car == null){
            car = new ConcreteCar(model);
            carMap.put(model,car);
        }
        return car;
    }
}
