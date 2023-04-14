package com.mashibing.dp.facadeMMY;

import com.mashibing.dp.facadeMMY.entity.Customer;
import com.mashibing.dp.facadeMMY.entity.Order;
import com.mashibing.dp.facadeMMY.entity.OrderRequest;
import com.mashibing.dp.facadeMMY.entity.SelectRequest;
import com.mashibing.dp.facadeMMY.repository.CustomerRepository;
import com.mashibing.dp.facadeMMY.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Order createOrder(OrderRequest orderRequest) {
        Customer customer = customerRepository.getCustomerById(orderRequest.getCustomerId()).get();
        if (customer == null) {
            throw new IllegalArgumentException("Invalid customer id");
        }

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(new Date());
        order.setTotalAmount(orderRequest.getTotalAmount());

//        orderRepository.save(order);

        return order;
    }
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }


    // selectRequest三个属性全有值
    public Page<Order> getAllOrders(SelectRequest selectRequest, Pageable pageable){
        Date sdate = selectRequest.getSdate();
        sdate.setHours(23);
        sdate.setMinutes(59);
        sdate.setSeconds(59);
        Specification<Order> byDateString = Specs.findByDateString(selectRequest.getFdate(),sdate);
        Specification<Order> bySpecAmount = Specs.findBySpecAmount(null, null, selectRequest.getCid());
        Specification<Order> orderSpecification = byDateString.and(bySpecAmount);

        // 实现分页查询

        return orderRepository.findAll(
                orderSpecification,pageable
        );
    }
    public Page<Order> getOrdersIfHasNull(SelectRequest selectRequest,Pageable pageable){

        if(selectRequest != null && selectRequest.getSdate() != null){
            Date sdate = selectRequest.getSdate();
            sdate.setHours(23);
            sdate.setMinutes(59);
            sdate.setSeconds(59);
        }

        // 为空 findAll
        if (selectRequest == null){
            return orderRepository.findAll(pageable);
            // 只有cid入参
        }else if (selectRequest.getFdate() == null&&selectRequest.getSdate() ==null&&selectRequest.getCid()!= null){
            Specification<Order> bySpecAmount = Specs.findBySpecAmount(null, null, selectRequest.getCid());
            return orderRepository.findAll(bySpecAmount,pageable);
        }else if (selectRequest.getFdate() != null&&selectRequest.getSdate() ==null&&selectRequest.getCid()!= null){
            Specification<Order> byDateString = Specs.findByDateString(selectRequest.getFdate(), null);
            Specification<Order> bySpecAmount = Specs.findBySpecAmount(null, null, selectRequest.getCid());
            return orderRepository.findAll(byDateString.and(bySpecAmount),pageable);
        }else if (selectRequest.getFdate() == null&&selectRequest.getSdate() !=null&&selectRequest.getCid()!= null){
            Specification<Order> byDateString = Specs.findByDateString(null, selectRequest.getSdate());
            Specification<Order> bySpecAmount = Specs.findBySpecAmount(null, null, selectRequest.getCid());
            return orderRepository.findAll(byDateString.and(bySpecAmount),pageable);
        }
        else if (selectRequest.getCid()==null&&selectRequest.getFdate()!=null&&selectRequest.getSdate()!=null){
            Specification<Order> byDateString = Specs.findByDateString(selectRequest.getFdate(), selectRequest.getSdate());
            return orderRepository.findAll(byDateString,pageable);
        }
        else if (selectRequest.getCid()==null&&selectRequest.getFdate()==null&&selectRequest.getSdate()!=null){
            Specification<Order> byDateString = Specs.findByDateString(null, selectRequest.getSdate());
            return orderRepository.findAll(byDateString,pageable);
        }
        else if (selectRequest.getCid()==null&&selectRequest.getFdate()!=null&&selectRequest.getSdate()==null){
            Specification<Order> byDateString = Specs.findByDateString(selectRequest.getFdate(), null);
            return orderRepository.findAll(byDateString,pageable);
        }else {
            return orderRepository.findAll(pageable);
        }

    }
}
