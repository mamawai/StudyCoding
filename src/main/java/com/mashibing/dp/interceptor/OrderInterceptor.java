package com.mashibing.dp.interceptor;

import com.mashibing.dp.facadeMMY.entity.OrderRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class OrderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("OrderPreHandler method is Calling");
        HttpSession session = request.getSession();

        //这里的User是登陆时放入session的
        OrderRequest orderRequest = (OrderRequest) session.getAttribute("orderRequest");
        //如果session中没有user，表示没登陆
        if (orderRequest.getCustomerId() == 1L){
            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("text/plain;charset=UTF-8");
//            response.getWriter().write("禁止给客户id为1的客户下单！");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendRedirect("redirect:/inputReq");
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("PostHandler method is Calling");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AfterCompletion method is Calling");
    }
}
