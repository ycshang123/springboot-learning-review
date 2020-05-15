package com.soft1851.springboot.task.scheduling.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cronId;

    @Column(name ="cron_name",nullable = false,length = 30)
    private String cronName;

    @Column(name="cron",nullable = false,length = 50)
    private String cron;
}
