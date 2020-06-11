package com.seckill.center;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "auth-center")
public interface AuthCenterApi {
}
