package com.soft1851.springboot.jpa.controller;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import com.soft1851.springboot.jpa.repository.TeacherRespository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/teacher")
public class TeacherController {
    @Resource
    private TeacherRespository teacherRespository;

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable int id) {
        return teacherRespository.findTeacherByIdEquals(id);
    }
}