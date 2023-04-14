package com.mashibing.dp.facadeMMY;

import com.mashibing.dp.facadeMMY.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class ExtraService {

    public void saveOrderPrint(Order order){
        System.out.println("保存了订单"+order);
    }
}
