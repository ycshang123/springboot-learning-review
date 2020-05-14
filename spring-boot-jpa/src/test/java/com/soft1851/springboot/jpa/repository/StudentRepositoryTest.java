package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Clazz;
import com.soft1851.springboot.jpa.model.cascade.Course;
import com.soft1851.springboot.jpa.model.cascade.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private ClazzRepository clazzRepository;
    @Resource

    @Test
    void findByClazzId() {
        List<Student> students = studentRepository.findByClazzId(1);
        Clazz clazz = clazzRepository.findClazzByIdEquals(1);
        clazz.setStudentList(students);
        System.out.println(clazz);
    }

    @Test
    void testManyToMany(){
        System.out.println("*************************************");
        List<Student> students = studentRepository.findByClazzId(1);
        students.forEach(student -> {
            System.out.println(student.getId()+"," + student.getStudentName() +"," +student.getAge());
            List<Course> courseList = student.getCourseList();
            courseList.forEach(course -> {
                System.out.println(course.getId() +"," +course.getCourseName());
            });
        });
    }
}