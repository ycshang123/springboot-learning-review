package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * 根据userName或age查询
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根据userId删除
     * @param userId
     * @return
     */
    int deleteByUserId(Integer userId);
}
