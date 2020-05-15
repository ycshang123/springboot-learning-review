package com.soft1851.springboot.jpa.controller;


import com.soft1851.springboot.jpa.model.cascade.Clazz;
import com.soft1851.springboot.jpa.repository.ClazzRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/clazz")
public class ClazzController {

    @Resource
    private ClazzRepository clazzRepository;

    @GetMapping("/{id}")
    public Clazz getClazz(@PathVariable int id){
        return clazzRepository.findClazzByIdEquals(id);
    }
}
