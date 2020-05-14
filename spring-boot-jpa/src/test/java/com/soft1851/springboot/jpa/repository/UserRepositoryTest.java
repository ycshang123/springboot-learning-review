package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    /**
     * 基础方法
     */
    @Test
    public void testBaseQuery() {

        /**
         * 查询全部user
         */
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);

        /**
         * 根据id查询用户
         */
        System.out.println(">>>>>>>>>>>>>>>>根据id查询用户：" + userRepository.findById(1L));


        /**
         *
         * 添加用户
         */
        User user = User.builder().id(3L).userName("插入用户").password("123456").email("222@qq.com").nickName("啦啦啦").age(18).build();
        userRepository.save(user);

        /**
         * 查询记录条数
         */
        long count = userRepository.count();
        System.out.println(">>>>>>>>>>>>>>>>查询表中数据条数：" + count);

        System.out.println(">>>>>>>>>>>>>>>>用户是否存在" + userRepository.existsById(3L));

        /**
         * 删除用户
         */
        userRepository.delete(user);

    }

    @Test
    void findByUserName() {
        User user = userRepository.findByUserName("尚宇驰");
        System.out.println(user);

    }

    @Test
    void findByUserNameOrEmail() {
        String username = "sss";
        String email = "111@qq.com";
        System.out.println(userRepository.findByUserNameOrEmail(username, email));

    }

    @Test
    void findByEmailLike() {
        String email = "111@qq.com";
        System.out.println(userRepository.findByEmailLike(email));
    }

    @Test
    void findByUserNameIgnoreCase() {
    }

    @Test
    void findByUserNameOrderByEmailDesc() {
    }

    @Test
    void findById() {
        Long id = 1L;
        System.out.println(">>>>>>>>>>>>>>自定义根据id查找用户" + userRepository.findById(id));
    }

    @Test
    void updateNickName() {
        String nickname = "修改用户名";
        long id = 2L;
        int n = userRepository.updateNickName(nickname, id);
        System.out.println(">>>>>>>>>>>>>>>>得到的count为" + n);
    }

    @Test
    void insertUser() {
        String name = "新增用户";
        String password = "123456";
        String email = "333@qq.com";
        int count = userRepository.insertUser(name, password, email);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>新增用户条数" + count);
    }

    @Test
    void testSave() {
        User user = User.builder()
                .userName("12345")
                .email("123456@qq.com")
                .password("123456")
                .nickName("aaabbb")
                .age(11)
                .regTime(LocalDateTime.now()).build();
        userRepository.save(user);

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
        userRepository.saveAll(users);
        System.out.println(users.size());
    }

    @Test
    void testSelect() {
        // 查询所有
        userRepository.findAll().forEach(user -> log.info(user.toString()));
        // 分页查询全部，返回封装了的分页信息， jpa页码从0开始
        Page<User> pageInfo = userRepository.findAll(
                PageRequest.of(1, 3, Sort.Direction.ASC, "id"));
        log.info("总记录数： {}", pageInfo.getTotalElements());
        log.info("当前页记录数： {}", pageInfo.getNumberOfElements());
        log.info("每页记录数： {}", pageInfo.getSize());
        log.info("获取总页数： {}", pageInfo.getTotalPages());
        log.info("查询结果： {}", pageInfo.getContent());
        log.info("当前页（从0开始计）： {}", pageInfo.getNumber());
        log.info("是否为首页： {}", pageInfo.isFirst());
        log.info("是否为尾页： {}", pageInfo.isLast());
        // 条件查询
        User user = User.builder().userName("user").build();
        List<User> users = userRepository.findAll(Example.of(user));
        log.info("满足条件的记录有：");
        users.forEach(user1 -> log.info(user1.toString()));
        // 单个查询
        User user1 = User.builder().id(2L).build();
        Optional<User> optionalUser = userRepository.findOne(Example.of(user1));
        log.info("单个查询结果： {}", optionalUser.orElse(null));
    }

    @Test
    void findByPassword() {
        String password = "123456";
        List<User> users = userRepository.findByPassword(password);
        users.forEach(System.out::println);
    }

    @Test
    void findByNickName() {
        String nickname = "nickName1";
        List<User> users = userRepository.findByNickName(nickname);
        System.out.println(users.size());

    }

    @Test
    void findALL() {
        Pageable pageable = PageRequest.of(1, 10, Sort.Direction.ASC, "id");
        userRepository.findALL(pageable).forEach(System.out::println);
    }

    @Test
    void testFindByNickName() {
        Pageable pageable = PageRequest.of(1, 10, Sort.Direction.ASC, "id");
        userRepository.findByNickName("nickName",pageable).forEach(System.out::println);
    }

    @Test
    void findTopByOrderByAgeDesc() {
        System.out.println(userRepository.findTopByOrderByAgeDesc());
    }



}