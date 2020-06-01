package com.seckill.controller;

import com.seckill.ordercenter.OrderCenter2Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payInfo")
public class PayInfoController {

    @Autowired
    private OrderCenter2Api orderCenterApi;

    /**
     * @return
     */
    @GetMapping("test")
    public String getTest(){
        return orderCenterApi.getOrder("123");
    }

}
