package com.seckill.quartz.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync
@Configuration
public class MultithreadScheduleTask {

    @Async
    @Scheduled(fixedRate = 2000)
    public void testFirst() throws InterruptedException {
        System.out.println("test frist");
        while (true){
            System.out.println("3333");
            Thread.sleep(1000);
        }
    }

    @Async
    @Scheduled(fixedRate = 3000)
    public void testSecond(){
        System.out.println("test second");
    }
}
