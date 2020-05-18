package com.soft1851.springboot.task.scheduling.controller;


import com.soft1851.springboot.task.scheduling.service.Impl.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ycshang
 */
@RestController
@Slf4j
public class AsyncTaskController {
    @Resource
    private AsyncTaskService asyncTaskService;
    @RequestMapping("/asyncTask")
    public String asyncTask(){
        asyncTaskService.asyncTask();
        return "测试异步任务...";
    }

    @RequestMapping("/sendEmail")
    public String asyncSendEmail(){
        asyncTaskService.sendEmail();
        return "邮件发送成功";
    }


}
