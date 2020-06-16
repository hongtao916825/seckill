package com.seckill.member;

import com.seckill.domain.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import seckill.common.api.CommonResult;

@FeignClient(name = "member-center")
public interface MemberCenterApi {

    @PostMapping("/member/selectUserByUserName")
    CommonResult<SysUser> selectUserByUserName(String username);

}
