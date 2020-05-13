package com.soft1851.springboot.jpa.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clazzId;

    @Column
    private String clazzName;
    @Column
    private Integer teacherId;

    @OneToOne
    @JoinColumn(name ="clazz_id",referencedColumnName = "clazz_id")
    private  Teacher teacher;
}
