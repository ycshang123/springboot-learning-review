package com.soft1851.springboot.task.scheduling.service;


import javax.mail.MessagingException;
import java.util.Map;

/**
 * @author ycshang
 */
public interface MailService {


    /**
     * 发送简单的文本邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleTextMail(String to,String subject,String content);

    /**
     * 发送HTML邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to,String subject,String content) throws MessagingException;

    /**
     * 发送附件邮件
     * @param to
     * @param subject
     * @param content
     * @param fileArr
     */
    void sendAttachmentMail(String to,String subject,String content,String... fileArr) throws MessagingException;

    /**
     * 发送图片邮件
     * @param to
     * @param subject
     * @param content
     * @param imgMap
     */
    void sendImgMail(String to, String subject, String content, Map<String,String> imgMap) throws MessagingException;

}
