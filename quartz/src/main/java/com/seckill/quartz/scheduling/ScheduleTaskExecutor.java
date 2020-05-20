package com.seckill.quartz.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

@Configuration
public class ScheduleTaskExecutor implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                ()-> System.out.println(789),
                triggerContext -> new CronTrigger("0/10 * * * * ?").nextExecutionTime(triggerContext));
    }

}
