package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void findByUserName() {
   User user = userRepository.findByUserName("尚宇驰");
        System.out.println(user);
    }
    
}