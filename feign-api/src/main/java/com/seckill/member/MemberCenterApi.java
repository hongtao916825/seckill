package com.seckill.member;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "member-center")
public interface MemberCenterApi {

    CommonResult<SysUser> selectUserByUserName(String username);

}
