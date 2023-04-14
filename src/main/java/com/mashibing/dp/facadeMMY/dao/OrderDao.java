package com.mashibing.dp.facadeMMY.dao;


import com.mashibing.dp.facadeMMY.entity.Customer;
import com.mashibing.dp.facadeMMY.entity.Order;
import com.mashibing.dp.facadeMMY.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class OrderDao {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    public Double getAVGAmount(String columnName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);
        Root<Order> root = query.from(Order.class);
        Expression<Long> expression = root.get(columnName);
        Expression<Double> avg = criteriaBuilder.avg(expression);
        query.select(criteriaBuilder.function("ROUND",Double.class,avg));
        TypedQuery<Double> query1 = entityManager.createQuery(query);
        return query1.getSingleResult();
    }

    public List<Order> findBySpecAmount(Double firstA, Double secondA, Long cid){
        List<Order> totalAmount = orderRepository.findAll(
                new Specification<Order>() {
                    @Override
                    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                        Predicate conjunction = criteriaBuilder.conjunction();

                        Expression<Double> totalAmount = root.get("totalAmount");
                        Path<Customer> customer = root.get("customer");
                        Path<Long> id = customer.get("id");
                        Predicate between = null;
                        if (firstA!=null && secondA!=null) {
                            between = criteriaBuilder.between(totalAmount, criteriaBuilder.literal(firstA), criteriaBuilder.literal(secondA));
                        }else if (firstA == null && secondA != null){
                            between = criteriaBuilder.between(totalAmount, criteriaBuilder.literal(0.0), criteriaBuilder.literal(secondA));
                        }else if (firstA != null && secondA == null){
                            between = criteriaBuilder.greaterThan(totalAmount,criteriaBuilder.literal(firstA));
                        }
                        Predicate equal = criteriaBuilder.equal(id , cid);

                        if (between != null) {
                            conjunction.getExpressions().add(between);
                        }
                        conjunction.getExpressions().add(equal);
                        System.out.println(conjunction.getOperator().toString());
                        return conjunction;
                    }
                }
        );
        return totalAmount;
    }

    public List<Order> findByDateString(String date) {


        List<Order> all = orderRepository.findAll(
                new Specification<Order>() {
                    @Override
                    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

//                        Expression<String> dateString = criteriaBuilder.function("DATE_FORMAT", String.class, root.get("orderDate"), criteriaBuilder.literal("%Y-%m-%d"));
                        return criteriaBuilder.like(root.get("orderDate").as(String.class),"%"+date+"%");
//                        return criteriaBuilder.like(dateString, "%" + date + "%");
                    }
                }
        );
        return all;
    }
}
