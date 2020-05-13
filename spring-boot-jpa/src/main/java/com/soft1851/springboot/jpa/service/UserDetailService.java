package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.UserDetail;
import com.soft1851.springboot.jpa.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface UserDetailService {


     Page<UserDetail> findByCondition(UserDetailParam userDetailParam, Pageable pageable);
}
