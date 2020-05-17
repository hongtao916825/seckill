package com.seckill.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Value("${test.name}")
    private String testName;

    @PostMapping("/getOrder/{orderId}")
    @HystrixCommand(fallbackMethod = "getOrderFallback")
    public String getOrder(@PathVariable("orderId") String orderId){
        return "orderId:" + orderId;
    }

    @GetMapping("/order/testNacosYml")
    @ResponseBody
    public String testNacosYml(){
        return testName;
    }

    public String getOrderFallback(String orderId, Throwable e){
        return "";
    }

    @GetMapping("testHystrix")
    @ResponseBody
    @HystrixCommand(commandKey = "testCommand", groupKey = "testGroup", threadPoolKey = "testThreadKey",
            fallbackMethod = "hiConsumerFallBack", ignoreExceptions = {NullPointerException.class},
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "101"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
            }
    )
    public String testHystrix(){
        return "";
    }

    public String hiConsumerFallBack(String orderId, Throwable e){
        return "";
    }
}
