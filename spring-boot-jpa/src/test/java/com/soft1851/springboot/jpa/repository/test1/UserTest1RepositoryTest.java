package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserTest1RepositoryTest {
    @Resource
    private UserTest1Repository userTest1Repository;

    @Test
    void testSave() {
        User user = User.builder()
                .userName("aaa")
                .email("aaa@qq.com")
                .password("aaa123")
                .nickName("aaabbb")
                .age(11)
                .regTime(LocalDateTime.now()).build();
        userTest1Repository.save(user);

        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            User testUser = User.builder()
                    .userName("user" + i)
                    .email("user" + i + "@qq.com")
                    .password("123456")
                    .nickName("nickName" + i)
                    .age(new Random().nextInt(50))
                    .regTime(LocalDateTime.now()).build();
            users.add(testUser);
        }
        userTest1Repository.saveAll(users);

    }

    @Test
    void findUsersByNickNameLike() {
    }

    @Test
    void findUsersByAgeGreaterThan() {
    }

    @Test
    void findById() {
        long id = 1;
        System.out.println(userTest1Repository.findById(id));
    }

    @Test
    void updateNickName() {
    }

    @Test
    void insertUser() {
    }

    @Test
    void testFindById() {
    }
}