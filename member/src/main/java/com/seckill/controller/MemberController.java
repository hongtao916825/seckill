package com.seckill.controller;

import com.seckill.domain.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seckill.common.api.CommonResult;

@RestController
@RequestMapping("/member/")
public class MemberController {

    

    @RequestMapping("selectUserByUserName")
    public CommonResult<SysUser> selectUserByUserName(String username){

    }

}
