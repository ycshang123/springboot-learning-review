package com.soft1851.springboot.application.bootstrap;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;


/**
 * @author ycshang
 */
public class SpringApplicationBootstrap {
    public static void main(String[] args) {
        //通过SpringApplication API自定义SpringApplication的启动参数
        Set<String> sources = new HashSet<>();
        sources.add(ApplicationConfiguration.class.getName());

        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        //关闭默认web配置
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.setAdditionalProfiles("dev");
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setHeadless(true);
        springApplication.run(args);
    }
    @SpringBootApplication
    public  static  class  ApplicationConfiguration{

    }

}
