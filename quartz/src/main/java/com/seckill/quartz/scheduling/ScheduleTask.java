package com.seckill.quartz.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class ScheduleTask {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void configureTasks() {
        System.out.println(123);
    }
}
