package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
class MessageRepositoryTest {
    @Autowired
    private  MessageRepository messageRepository;
    @Test
    public void testSave() {
        Message message = Message.builder().msgText("软件1851").msgSummary("沉迷学习").build();
        // 保存单个对象
        messageRepository.save(message);

        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("后端").msgSummary("SpringBoot").build(),
                Message.builder().msgText("前端").msgSummary("Vue.js").build(),
                Message.builder().msgText("移动端").msgSummary("Flutter").build()));
        // 保存多个
        messageRepository.saveAll(messages);
    }

}