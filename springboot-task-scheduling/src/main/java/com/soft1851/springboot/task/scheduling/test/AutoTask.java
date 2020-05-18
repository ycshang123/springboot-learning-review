package com.soft1851.springboot.task.scheduling.test;


import com.soft1851.springboot.task.scheduling.repository.CronRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;

@Slf4j
//@Configuration
public class AutoTask implements SchedulingConfigurer {
    @Resource
    protected CronRepository cronRepository;

    private String newCron = "0/3 * * * * ?";
    private Integer cronId = 1;

//    @Bean
//    public Executors setTaskExecutors() {
//        //创建一个基本大小为3的线程池
//        return Executors.newScheduledThreadPool(3);
//    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> {
                    String cron = cronRepository.findCronByCronIdEquals(cronId).getCron();
                    //定时任务内容
                    log.info("当前时间：" + LocalDateTime.now());
                    if (!cron.equals(newCron)) {
                        log.info("定时任务参数修改");
                        cronRepository.updateCron(newCron, cronId);
                    }
                },
                triggerContext -> {
                    return new CronTrigger(newCron).nextExecutionTime(triggerContext);
                }
        );

//        scheduledTaskRegistrar.addTriggerTask(this::process,
//                triggerContext -> {
//            //这里就先查询了id为1的cron
//                    String cron = cronRepository.findCronByCronIdEquals(1).getCron();
//                    log.info(cron);
//                    if(cron.isEmpty()){
//                        log.info("cron为空");
//                    }
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                });

    }

    private void process() {
        log.info("从数据库中读取cron...");
    }
}
