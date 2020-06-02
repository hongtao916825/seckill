package com.seckill.ordercenter;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "gateway")
public interface ProductCenterApi {
}
