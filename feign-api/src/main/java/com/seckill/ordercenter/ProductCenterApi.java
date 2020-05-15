package com.seckill.ordercenter;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product-center")
public interface ProductCenterApi {
}
