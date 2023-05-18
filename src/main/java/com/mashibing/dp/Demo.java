package com.mashibing.dp;


import com.mashibing.dp.facadeMMY.*;
import com.mashibing.dp.facadeMMY.dao.CustomerDao;
import com.mashibing.dp.facadeMMY.dao.OrderDao;
import com.mashibing.dp.facadeMMY.entity.Order;
import com.mashibing.dp.facadeMMY.repository.CustomerRepository;
import com.mashibing.dp.facadeMMY.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class Demo {
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(Demo.class, args);
        System.out.println(
                "  ____  __  __    ___    ___     __    ____    ____  \n" +
                        " /',__\\/\\ \\/\\ \\  /'___\\ /'___\\ /'__`\\ /',__\\  /',__\\ \n" +
                        "/\\__, `\\ \\ \\_\\ \\/\\ \\__//\\ \\__//\\  __//\\__, `\\/\\__, `\\\n" +
                        "\\/\\____/\\ \\____/\\ \\____\\ \\____\\ \\____\\/\\____/\\/\\____/\n" +
                        " \\/___/  \\/___/  \\/____/\\/____/\\/____/\\/___/  \\/___/ \n");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local访问网址: \t\thttp://localhost:" + "8080" + "/guide" + "\n\t" +
                "----------------------------------------------------------");

    }
    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository, CustomerRepository customerRepository, CustomerDao customerDao, OrderDao orderDao){
        return args -> {
////            ArrayList<String> strings = new ArrayList<>();
////            strings.add("aa");
///*            String[] strings =new String[2];
//            strings[0] = "aa";
//            strings[1] = "bb";
//            List<Customer> byFirstNames = customerRepository.findByFirstNames(strings);
//            System.out.println(byFirstNames);*/
//
////            Customer customer = new Customer();
////            customer.setFirstName("b");
////            customer.setLastName("BB");
////            List<Customer> customer1 = customerDao.findCustomer(customer);
////            System.out.println(customer1);
//            /*Double totalAmount = orderDao.getAVGAmount("totalAmount");
//            System.out.println(totalAmount);*/
//
////            List<Order> byDateString = orderDao.findByDateString("2023-03-31");
////            System.out.println(byDateString);
//
//            List<Order> bySpecAmount = orderDao.findBySpecAmount(2000.0, null,2L);
//            System.out.println(bySpecAmount);
//
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String dateString ="2023-03-27";
//            Date parse = sdf.parse(dateString);
//            Specification<Order> spec = Specification.where(null);
//            int compare = date.compareTo(parse);
//            if (compare>0) {
//                spec = spec.and(Specs.findByDateString(dateString));
//            }
//            Specification<Order> bySpecAmount2 = Specs.findBySpecAmount(200.0, 200000.0, 2L);
//            Specification<Order> not2 = Specification.not(bySpecAmount2);
//            spec = spec.and(not2);
//
//            List<Order> all = orderRepository.findAll(spec);
//            System.out.println(all);
//            Specification<Order> bySpecAmount1 = Specs.findBySpecAmount(200.0, 200000.0, 2L);
////            List<Order> all = orderRepository.findAll(
////                  spec.and(byDateString).and(bySpecAmount1)
////            );
////            System.out.println(all);
//
//            Specification<Order> spec2 = (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"),4L);
//            List<Order> all1 = orderRepository.findAll(Specification.not(spec2));
//            System.out.println(all1);
            String sdate = "2023-03-28";
            String fdate = "2023-03-27";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date Fdate = sdf.parse(fdate);
            Date Sdate = sdf.parse(sdate);
            Sdate.setHours(23);
            Sdate.setMinutes(59);
            Sdate.setSeconds(59);
            System.out.println(Fdate+"  "+Sdate);
            List<Order> all = orderRepository.findAll(
                    Specs.findByDateString(Fdate, Sdate)
            );
            System.out.println(all);
        };
    }
}
