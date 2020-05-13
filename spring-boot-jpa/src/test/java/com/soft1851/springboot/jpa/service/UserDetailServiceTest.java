package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.UserDetail;
import com.soft1851.springboot.jpa.param.UserDetailParam;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserDetailServiceTest {
    @Resource
    private  UserDetailService userDetailService;

    @Test
    void findByCodition() {
        UserDetailParam param = new UserDetailParam();
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "id");
        param.setIntroduction("程序员");
        param.setMinAge(10);
        param.setMaxAge(30);
        Page<UserDetail> page = userDetailService.findByCondition(param,pageable);
        for(UserDetail userDetail :page){
            System.out.println("userDetail" + userDetail.toString());
        }
    }
}