package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class TeacherRespositoryTest {
    @Resource
    private  TeacherRespository teacherRespository;
    @Test
    void testOneToOne(){
        List<Teacher> teachers = teacherRespository.findAll();
        teachers.forEach(System.out::println);
    }
    @Test
    void findTeacherByIdEquals() {
        System.out.println(teacherRespository.findTeacherByIdEquals(1));
    }

}