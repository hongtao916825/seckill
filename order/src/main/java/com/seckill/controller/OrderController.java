package com.seckill.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Value("${test.name}")
    private String testName;

    @PostMapping("/getOrder/{orderId}")
    @HystrixCommand(fallbackMethod = "getOrder")
    public String getOrder(@PathVariable("orderId") String orderId){
        return "orderId:" + orderId;
    }

    @GetMapping("/order/testNacosYml")
    @ResponseBody
    public String testNacosYml(){
        return testName;
    }

}
