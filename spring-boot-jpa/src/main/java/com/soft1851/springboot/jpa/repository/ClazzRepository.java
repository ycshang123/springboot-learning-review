package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClazzRepository  extends JpaRepository<Clazz,Integer> {

    /**
     * 根据id查询班级
     * @param id
     * @return
     */
    Clazz findClazzByIdEquals(int id);

}
