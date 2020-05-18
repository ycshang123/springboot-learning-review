package com.soft1851.springboot.task.scheduling.service.Impl;


import com.soft1851.springboot.task.scheduling.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ycshang
 */
@Service
@Slf4j
public class AsyncTaskService {
    @Resource
    private MailService mailService;
    @Async
    public void asyncTask(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理数据中");
    }

    @Async
    public void sendEmail(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理数据中");
        String to = "351234359@qq.com";
        String subject = "Springboot 发送简单文本邮件";
        String content = "第一封Springboot简单文本邮件";
        mailService.sendSimpleTextMail(to,subject,content);
    }
}
