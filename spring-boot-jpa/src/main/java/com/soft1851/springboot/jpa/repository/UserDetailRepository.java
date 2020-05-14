package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.dao.UserInfo;
import com.soft1851.springboot.jpa.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDetailRepository  extends JpaSpecificationExecutor<UserDetail> , JpaRepository<UserDetail,Long> {
    @Query("select u.userName as userName, u.email as email, d.introduction as introduction , d.hobby as hobby from User u , UserDetail d " +
            "where u.id=d.userId  and  d.hobby = ?1 ")
    List<UserInfo> findUserInfo(String hobby);
}
