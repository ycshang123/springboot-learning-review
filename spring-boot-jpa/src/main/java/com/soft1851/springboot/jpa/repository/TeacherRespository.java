package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRespository extends JpaRepository<Teacher,Long> {


    /**
     * 根据id查找
     * @param id
     * @return
     */
    Teacher findTeacherByIdEquals(int id);
}
