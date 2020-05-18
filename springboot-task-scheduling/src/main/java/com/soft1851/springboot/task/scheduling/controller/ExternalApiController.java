package com.soft1851.springboot.task.scheduling.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ycshang
 */
@Controller
public class ExternalApiController {

    @GetMapping("/external/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello stranger");
    }
}
