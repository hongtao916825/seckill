package com.seckill.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/getOrder/{orderId}")
    @HystrixCommand(fallbackMethod = "getOrder")
    public String getOrder(@PathVariable("orderId") String orderId){
        return "orderId:" + orderId;
    }

}
