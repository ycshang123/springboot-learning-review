package com.soft1851.springboot.jpa.model.cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author ycshang
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;

   @Column(name="student_name",nullable = false,length = 30)
    private String studentName;

   @Column(name ="age",nullable = false,length = 30)
    private Integer age;
}
