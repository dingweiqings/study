package com.ding.spring.hbernate.study.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//CLuster
/**
 * @author kurt.ding
 * @date 2021/11/17 下午5:15
 */
@Entity
@Table
@Data
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String age;
	@OneToOne(cascade = CascadeType.ALL)
	Child childs ;

}
