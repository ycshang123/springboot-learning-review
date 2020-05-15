package com.soft1851.springboot.task.scheduling.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;

    @Resource
    private TemplateEngine templateEngine;

    @Test
    void sendSimpleTextMail() {
        String to = "351234359@qq.com";
        String subject = "Springboot 发送简单文本邮件";
        String content = "第一封Springboot简单文本邮件";
        mailService.sendSimpleTextMail(to,subject,content);
    }

    @Test
    void sendHtmlMail() throws MessagingException {
        String to ="351234359@qq.com";
        String subject ="Springboot发送thymeleaf邮件";
        Context  context = new Context();
        context.setVariable("username","ycshang");
        String emailContext = templateEngine.process("template",context);
        mailService.sendHtmlMail(to,subject,emailContext);
//        String to ="351234359@qq.com";
//        String subject ="Springboot发送HTML邮件";
//        String content = "<h3>第一封Springboot简单文本邮件</h3>";
//        mailService.sendHtmlMail(to,subject,content);
    }

    @Test
    void sendAttachmentMail() throws MessagingException {
        String to ="351234359@qq.com";
        String subject ="Springboot发送附件邮件";
        String content = "<h2>第一封Springboot附件邮件</h2>";
        String filePath ="pom.xml";
        mailService.sendAttachmentMail(to,subject,content,filePath,filePath);

    }

    @Test
    void sendImgMail() throws MessagingException {
        String to ="351234359@qq.com";
        String subject ="Springboot 发送图片邮件";
        String content ="<h2>第一封Springboot图片邮件</h2><br/><img src=\"cid:img01\"/>";
        String imgPath = "D:/images/2.jpg";
        Map<String,String> imgMap = new HashMap<>();
        //以键值对的形式存入
        imgMap.put("img01",imgPath);
        mailService.sendImgMail(to,subject,content,imgMap);
    }
}