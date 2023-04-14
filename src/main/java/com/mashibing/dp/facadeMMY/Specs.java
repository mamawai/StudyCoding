package com.mashibing.dp.facadeMMY;

import com.mashibing.dp.facadeMMY.entity.Customer;
import com.mashibing.dp.facadeMMY.entity.Order;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Date;

public class Specs {
    public static Specification<com.mashibing.dp.facadeMMY.entity.Order> findByDateString(Date fdate, Date sdate){

        return new Specification<com.mashibing.dp.facadeMMY.entity.Order>() {
            @Override
            public Predicate toPredicate(Root<com.mashibing.dp.facadeMMY.entity.Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               if (fdate == null && sdate != null){
                   return criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"),sdate);
               }else if (sdate == null && fdate!= null){
                   return criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"),fdate);
               }
                return criteriaBuilder.between(root.get("orderDate"),fdate,sdate);

            }
        };
    }
    public static Specification<com.mashibing.dp.facadeMMY.entity.Order> findBySpecAmount(Double firstA, Double secondA, Long cid){
        return new Specification<com.mashibing.dp.facadeMMY.entity.Order>() {
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
                return conjunction;
            }
        };
    }
}
