//package com.mashibing.dp.facadeMMY;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class Application {
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
////    @Autowired
////    OrderFacade orderFacade;
////    @Bean
////    CommandLineRunner commandLineRunner(OrderRepository orderRepository,CustomerRepository customerRepository){
////        return args -> {
////            OrderRequest orderRequest = new OrderRequest();
////            orderRequest.setCustomerId(1L);
////            orderRequest.setTotalAmount(888);
////            Order order = orderFacade.createOrder(orderRequest);
////            System.out.println(order);
////        };
////    }
//}
