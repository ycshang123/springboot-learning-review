package com.soft1851.springboot.jpa.model.cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author ycshang
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String teacherName;

    @OneToOne
    @JoinColumn(name ="clazz_id",referencedColumnName = "id")
    private  Clazz clazz;
}
