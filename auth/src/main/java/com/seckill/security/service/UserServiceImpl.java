package com.seckill.security.service;

import com.seckill.domain.LoginUser;
import com.seckill.domain.SysUser;
import com.seckill.member.MemberCenterApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import seckill.common.api.CommonResult;

@Service("userDetailsServiceImpl")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private MemberCenterApi memberCenterApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CommonResult<SysUser> sysUserCommonResult = memberCenterApi.selectUserByUserName(username);
        SysUser sysUser = sysUserCommonResult.getData();
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(sysUser);
        return loginUser;
    }

}
