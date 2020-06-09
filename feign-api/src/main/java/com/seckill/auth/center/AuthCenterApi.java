package com.seckill.auth.center;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "auth-center")
public interface AuthCenterApi {
}
