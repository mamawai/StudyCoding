package com.mashibing.dp.facadeMMY.dao;


import com.mashibing.dp.facadeMMY.entity.Customer;
import com.mashibing.dp.facadeMMY.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findCustomer(Customer customer){
        List<Customer> all = customerRepository.findAll(
                new Specification<Customer>() {
                    @Override
                    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                        // 获取条件参数对象
                        Predicate predicate = criteriaBuilder.conjunction();
//                        List<Expression<Boolean>> expressions = predicate.getExpressions();

                        // 判断customer不为空
                        if (customer != null) {
                            // 判断fn是否为空
                            if (customer.getFirstName() != null && !customer.getFirstName().equals("")) {
                                // 不为空则拼接条件 模糊查询
                                predicate.getExpressions().add(criteriaBuilder.like(root.get("firstName"), "%" + customer.getFirstName() + "%"));
                            }
                            if (customer.getLastName() != null) {
                                // 精确查询
                                predicate.getExpressions().add(criteriaBuilder.equal(root.get("LastName"), customer.getLastName()));
                            }
                        }
                        return predicate;
                    }
                }
        );
        return all;
    }



}
