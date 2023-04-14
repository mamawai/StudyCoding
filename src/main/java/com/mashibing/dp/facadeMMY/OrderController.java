package com.mashibing.dp.facadeMMY;

import com.mashibing.dp.facadeMMY.entity.Customer;
import com.mashibing.dp.facadeMMY.entity.Order;
import com.mashibing.dp.facadeMMY.entity.OrderRequest;
import com.mashibing.dp.facadeMMY.entity.SelectRequest;
import com.mashibing.dp.facadeMMY.repository.CustomerRepository;
import com.mashibing.dp.facadeMMY.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class OrderController {

    private static SelectRequest sr = null;
    private static Integer PAGE_SIZE = 5;

    @Autowired
    private OrderFacade orderFacade;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/inputReq")
    public String inputReq(){
        return "input";
    }

    @PostMapping("/sendReq")
    public String sendReq(OrderRequest orderRequest, HttpSession httpSession){
        Order order = null;
        try {
            order = orderFacade.createOrder(orderRequest);
            httpSession.setAttribute("orderRequest",orderRequest);
            httpSession.setAttribute("order",order);
        } catch (NoSuchElementException e) {
            return "warning";
        }
        // 重定向后接的是路径
        return "redirect:/getorders";
    }
    @GetMapping("/getorders")
    public String getOrder(Model model,HttpSession httpSession){
        Long id = null;
        try {
            if (httpSession.getAttribute("order")!=null){
            // 网页跳转的时候可以通过session来传递值，在后端和前端用Model来传递值
            Order order = orderFacade.saveOrder((Order) httpSession.getAttribute("order"));
            httpSession.setAttribute("order",null);
            httpSession.setAttribute("id",order.getId());
            id = order.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id != null) {
            Order order = orderRepository.findById(id).get();
            model.addAttribute("order",order);
        }else {
            Optional<Order> optionalOrder = orderRepository.findById((Long) httpSession.getAttribute("id"));
            boolean isExist = optionalOrder.isPresent();
            if (isExist){
                Order order = optionalOrder.get();
                model.addAttribute("order",order);
            }else {
                Order noOrder = new Order();
                noOrder.setId(-1L);
                noOrder.setCustomer(new Customer(-1L,"-1","-1"));
                noOrder.setTotalAmount(0.0);
                noOrder.setOrderDate(new Date());
                model.addAttribute("order",noOrder);
            }

        }

        // 直接返回的是网页html
        return "OneOrder";
    }

    @RequestMapping(value = "/deleteCurrent/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        if (id <= 0L){
            return "warning";
        }
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "warning";
        }
        return "redirect:/inputReq";
    }

    @GetMapping("/customers")
    public String createOrder(Model model){
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customersList",customers);
        return "customers_list";
    }

    //查询页
    @RequestMapping("/inputSelect")
    public String gotoSelect(Model model){
        model.addAttribute("currentPage",0);
        model.addAttribute("totalPages",0);

        return "select";
    }
    //起始页
    @RequestMapping("/guide")
    public String guide(){
        return "index";
    }

    // 每次点击搜索的时候会到这里来
    @PostMapping("/inSelect/page=/{p}")
    public String postInSelect(@PathVariable("p") int page, SelectRequest selectRequest, Model model,HttpSession session){
        if (selectRequest != null && selectRequest.getCid() != null) {
            session.setAttribute("inputCid",selectRequest.getCid());
        }

        // 每一次新的搜索都会给sr一个新值
        sr = selectRequest;
        return pageSelect(page, model);
    }

    // 每次点击上一页或下一页会到这里来
    @GetMapping("/inSelect/page=/{p}")
    public String getInSelect(@PathVariable("p") int page, Model model){
        return pageSelect(page, model);
    }

    private String pageSelect(@PathVariable("p") int page, Model model) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);// 每页显示5条数据
        Page<Order> ordersPage = null;
        ordersPage = orderFacade.selectAllOrders(sr,pageable);
        assert ordersPage != null;
        model.addAttribute("PageSize",PAGE_SIZE);
        model.addAttribute("specOrders",ordersPage.getContent());
        model.addAttribute("currentPage",ordersPage.getNumber());// 0 1 2
        model.addAttribute("totalPages",ordersPage.getTotalPages());// 3
        System.out.println(ordersPage.getNumber()+" "+ordersPage.getTotalPages());
        return "select";
    }
}
