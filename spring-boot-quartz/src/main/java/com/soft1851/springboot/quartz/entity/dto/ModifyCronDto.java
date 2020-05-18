package com.soft1851.springboot.quartz.entity.dto;

import lombok.Data;

/**
 * @author ycshang
 * @className ModifyCronDto
 * @Description 修改cron表达式的dto类
 * @Date 2020/5/18
 * @Version 1.0
 **/
@Data
public class ModifyCronDto {
    /**
     * 作业的id
     */
    private Integer id;

    /**
     * 作业的cron表达式
     */
    private String cron;

}