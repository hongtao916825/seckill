package com.seckill;

import com.seckill.ordercenter.OrderCenterApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@SpringBootTest(classes = PayApplication.class)
@RunWith(SpringRunner.class)
class PayApplicationTests {

    @Autowired
    private OrderCenterApi orderCenterApi;

    @Test
    public void test(){
        System.out.println(orderCenterApi.getOrder("1234"));
    }


}
