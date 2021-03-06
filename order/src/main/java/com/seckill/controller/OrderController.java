package com.seckill.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Api("订单服务")
public class OrderController {

    @Value("${test.name}")
    private String testName;

    @PostMapping("/getOrder/{orderId}")
    @HystrixCommand(fallbackMethod = "getOrderFallback")
    @ApiOperation("获取用户详细")
    @ApiImplicitParam(name = "orderId", value = "订单ID", required = true, dataType = "String", paramType = "path")
    public String getOrder(@PathVariable("orderId") String orderId){
        return "orderId2:" + orderId;
    }

    @GetMapping("/testNacosYml")
    @ResponseBody
    public String testNacosYml(){
        return testName;
    }

    public String getOrderFallback(String orderId, Throwable e){
        return "";
    }

    @GetMapping("/testHystrix/{orderId}")
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
    public String testHystrix(@PathVariable("orderId") String orderId){
        return orderId;
    }

    public String hiConsumerFallBack(String orderId, Throwable e){
        return "33334：" + orderId + e.getMessage();
    }
}
