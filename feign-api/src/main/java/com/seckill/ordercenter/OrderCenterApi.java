package com.seckill.ordercenter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "gateway")
public interface OrderCenterApi {

    @PostMapping("order-center/getOrder/{orderId}")
    String getOrder(@PathVariable("orderId") String orderId);

}
