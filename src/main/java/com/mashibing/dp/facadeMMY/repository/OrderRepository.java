package com.mashibing.dp.facadeMMY.repository;


import com.mashibing.dp.facadeMMY.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long>, JpaSpecificationExecutor<Order> {

//    @Query(nativeQuery = true,value = "select * from orders where  if(?1!='',customer_Id = ?1,1=1)")
//    @Query(nativeQuery = true,value = "select * from orders where " +
//            "CASE WHEN ?1!='' THEN customer_Id = ?1 " +
//            " ELSE 1=1 END ;")


    @Query(nativeQuery = true,value = "select * from orders as o where o.customer_Id in ?1")
    List<Order> findOneOrSeveral(List<Long> cid);
}
