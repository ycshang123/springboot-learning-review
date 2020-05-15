package com.soft1851.springboot.task.scheduling.service.Impl;


import com.soft1851.springboot.task.scheduling.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @author ycshang
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.username}")
    private String from;
    @Resource
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleTextMail(String to, String subject, String content) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailMessage.setFrom(from);
        mailSender.send(mailMessage);
        log.info("文本邮件发送成功！to={}",to);
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        //true为HTML邮件
        messageHelper.setText(content,true);
        mailSender.send(message);
        log.info("[HTML邮件]成功发送！to={}",to);
    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String... fileArr) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content,true);
        //添加附件
        for(String filePath : fileArr){
            FileSystemResource fileResource = new FileSystemResource(new File(filePath));
            if(fileResource.exists()){
                String fileName = fileResource.getFilename();
                assert  fileName != null;
                messageHelper.addAttachment(fileName,fileResource);
            }
        }
        mailSender.send(mimeMessage);
        log.info("[附件邮件]成功发送！to={}",to);
    }

    @Override
    public void sendImgMail(String to, String subject, String content, Map<String, String> imgMap) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content,true);
        //添加图片
        for(Map.Entry<String,String> entry :imgMap.entrySet()){
            FileSystemResource fileResource = new FileSystemResource(new File(entry.getValue()));
            if(fileResource.exists()){
                messageHelper.addInline(entry.getKey(),fileResource);
            }
        }
        mailSender.send(mimeMessage);
        log.info("[图片邮件]成功发送！to={}",to);
    }


}
