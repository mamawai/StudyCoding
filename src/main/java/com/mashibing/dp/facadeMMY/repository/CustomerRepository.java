package com.mashibing.dp.facadeMMY.repository;

import com.mashibing.dp.facadeMMY.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> , JpaSpecificationExecutor<Customer> {
    @Transactional
    Optional<Customer> getCustomerById(Long aLong);

//    @Override
//    List<Customer> findAll();

    @Query(nativeQuery = true,value = "select * from customers as o where o.first_name in ?1")
    List<Customer> findByFirstNames(String[] FNs);
}
