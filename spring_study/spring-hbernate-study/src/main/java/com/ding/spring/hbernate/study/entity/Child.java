package com.ding.spring.hbernate.study.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//ClusterRequest
@Entity
@Data
public class Child {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String age;
    @OneToOne
    @JoinColumn(name = "person_id")
    Person person;

    @OneToOne(cascade = CascadeType.ALL)
    GrandChild grandChildren;
}
