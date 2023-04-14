package com.mashibing.dp.facadeMMY;

import com.mashibing.dp.facadeMMY.entity.Order;
import com.mashibing.dp.facadeMMY.entity.OrderRequest;
import com.mashibing.dp.facadeMMY.entity.SelectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderFacade {
    @Autowired
    private OrderService orderService;

    // Facade模式 这里应该会注入多个对象并调用其方法 实现类与类之间的交互，这里简单写了
    @Autowired
    private ExtraService extraService;

    public Order createOrder(OrderRequest orderRequest){
        return orderService.createOrder(orderRequest);
    }
    public Order saveOrder(Order order){
        Order saveOrder = orderService.saveOrder(order);
        extraService.saveOrderPrint(saveOrder);
        return saveOrder;
    }
    public Page<Order> selectAllOrders(SelectRequest selectRequest, Pageable pageable){

        if (selectRequest == null){
            return orderService.getOrdersIfHasNull(selectRequest,pageable);
        }

        if (selectRequest.getSdate()!=null&&selectRequest.getCid()!=null&&selectRequest.getFdate()!=null) {
            return orderService.getAllOrders(selectRequest, pageable);
        }else {
            return orderService.getOrdersIfHasNull(selectRequest,pageable);
        }
    }
}
