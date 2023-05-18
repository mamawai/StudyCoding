package com.mashibing.dp.cglibBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CglibTestController {
    @GetMapping("/test")
    @ResponseBody
    public String testProxy(){
        CglibProxy cglibProxy = new CglibProxy();
        ProxyService proxyService = new ProxyService();
        ProxyService proxy = (ProxyService) cglibProxy.createProxy(proxyService);
        return proxy.performOperation();
    }
}
