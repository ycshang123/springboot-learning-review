package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.dao.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
class UserDetailRepositoryTest {
    @Resource
    private UserDetailRepository userDetailRepository;

    @Test
    void findUserInfo() {
        List<UserInfo> userInfos = userDetailRepository.findUserInfo("编程");
        for(UserInfo userInfo:userInfos){
            System.out.println("userInfo:" +userInfo.getUserName()+"-"+userInfo.getEmail()+"-"+userInfo.getHobby()+"-"+userInfo.getIntroduction());
        }
    }
}