package com.soft1851.springboot.jpa.param;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ycshang
 */
@Data
public class UserDetailParam {
    private  String introduction;
    private  String realName;
    private Integer minAge;
    private Integer maxAge;

}

