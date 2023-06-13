package com.ding.spring.hbernate.study.entity;

import lombok.Data;

import javax.persistence.*;
//slurmConfig
@Entity
@Data
public class GrandChild {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String age;
    @OneToOne
    @JoinColumn(name = "p_child_id")
    Child pChild;
}
