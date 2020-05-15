package com.soft1851.springboot.task.scheduling.test;


import com.soft1851.springboot.task.scheduling.model.UserMail;
import com.soft1851.springboot.task.scheduling.repository.UserRepository;
import com.soft1851.springboot.task.scheduling.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class BirthdayTask {
    @Resource
    private UserRepository userRepository;
    @Resource
    private MailService mailService;

    @Scheduled(cron ="0 14 1 * * ?")
    private void process() throws  Exception{
        List<UserMail> userList = userRepository.findUsersByBirthday();
        for(UserMail user : userList){
            String to = user.getMail();
            String subject = "一份生日祝福,请注意查收";
            String content =user.getUsername()+"将快乐化为美妙的音符，作为礼物，在那个特别的日子里送给你，" +
                    "愿你天天都有好心情，一生都幸福，平安，衷心地祝福你——生日快乐！</br>"
                    +"<img src=\"cid:img01\"/>";
            String imgPath ="D:/images/3.png";
            Map<String,String> birthday = new HashMap<>();
            birthday.put("img01",imgPath);
            mailService.sendImgMail(to,subject,content,birthday);
            log.info("【生日邮件】邮件发送成功");
        }
    }

}
