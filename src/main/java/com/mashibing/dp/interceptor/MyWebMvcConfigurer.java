package com.mashibing.dp.interceptor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@ComponentScan
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private OrderInterceptor orderInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(orderInterceptor).addPathPatterns("/getorders/**");
//        registry.addInterceptor(selectInterceptor).addPathPatterns("/inSelect/page=/**");
    }


}
