package com.soft1851.springboot.jpa.repositiry;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ycshang
 */
public interface UserRepository extends JpaRepository<User,Long> {


    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User findByUserName(String userName);


    /**
     * 使用or关键字
     * @param username
     * @param email
     * @return
     */
    User findByUserNameOrEmail(String username,String email);

    /**
     * 使用like关键字
     * @param email
     * @return
     */
    List<User> findByEmailLike(String email);


    /**
     * 使用IgnoreCase关键字
     * @param userName
     * @return
     */
    User findByUserNameIgnoreCase(String userName);


    /**
     * 使用OrderBy关键字
     * @param email
     * @return
     */
    List<User> findByUserNameOrderByEmailDesc(String email);


    /**
     * 自定义JPQL查询，在接口上使用@Query
     * @param id
     * @return
     */
    @Query("select u from User u where u.id = ?1")
    User findById(long id);

    /**
     * 根据id修改用户名
     * @param nickname
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update user set nick_name = ?1 where id = ?2", nativeQuery = true)
    int updateNickName(String nickname,long id);

    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "insert into user(user_name, password,email) values (:userName, :password,:email)", nativeQuery = true)
    int insertUser(@Param("userName") String userName,@Param("password") String password,@Param("email") String email);


    /**
     * 在model通过@NamedQueries定义sql语句，实现查询
     * @param password
     * @return
     */
    List<User> findByPassword(String password);

    /**
     * 通过昵称查询用户
     * @param nickname
     * @return
     */
    List<User> findByNickName(String nickname);

    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    Page<User> findByNickName(String nickname,Pageable pageable);


    Slice<User> findByNickNameAndEmail(String nickname,String email,Pageable pageable);


    User findTopByOrderByAgeDesc();



}
