package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Clazz;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClazzRepositoryTest {
    @Resource
    private ClazzRepository clazzRepository;

    @Test
    void findClazzByIdEquals() {
        Clazz clazz = clazzRepository.findClazzByIdEquals(1);
        System.out.println(clazz);
    }
}