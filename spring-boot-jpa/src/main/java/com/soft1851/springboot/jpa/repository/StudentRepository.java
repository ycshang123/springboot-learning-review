package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student,Integer> {
}
