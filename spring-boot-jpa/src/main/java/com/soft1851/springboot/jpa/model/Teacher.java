package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)
    private Integer teacherId;

    @Column
    private String teacherName;
    @Column
    private Integer clazzId;
}
