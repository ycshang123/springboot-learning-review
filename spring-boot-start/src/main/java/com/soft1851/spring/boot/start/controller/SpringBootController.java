package com.soft1851.spring.boot.start.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @descrition :标准的Spring Boot RESTController
 */
@RestController
@RequestMapping("/api")
public class SpringBootController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello,Spring Boot!";
    }
}
