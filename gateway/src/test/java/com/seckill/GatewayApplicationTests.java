package com.seckill;

import com.seckill.ordercenter.OrderCenterApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GatewayApplication.class)
class GatewayApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private OrderCenterApi orderCenterApi;

    @Test
    public void test1(){
        System.out.println(orderCenterApi.getOrder("1234"));
    }


}
