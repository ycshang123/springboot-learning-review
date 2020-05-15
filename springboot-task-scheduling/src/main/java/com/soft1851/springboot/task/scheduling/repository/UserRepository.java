package com.soft1851.springboot.task.scheduling.repository;

import com.soft1851.springboot.task.scheduling.model.UserMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserMail,Long> {

    /**
     * 查找当天过生日的用户
     * @return
     */
    @Query(value = "SELECT * FROM user_mail WHERE MONTH(birthday) = MONTH(NOW()) AND DAY(birthday) = DAY(NOW())",nativeQuery = true)
    List<UserMail> findUsersByBirthday();

}
