package com.seckill.ordercenter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "order-center2")
public interface OrderCenter2Api {

    @PostMapping("/getOrder/{orderId}")
    String getOrder(@PathVariable("orderId") String orderId);

}
