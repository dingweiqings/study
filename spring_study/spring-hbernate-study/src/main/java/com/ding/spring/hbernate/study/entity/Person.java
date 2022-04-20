package com.ding.spring.hbernate.study.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kurt.ding
 * @date 2021/11/17 下午5:15
 */
@Entity
@Table
@Data
public class Person {
	@Id
	private String id;
	private String name;
	private String age;
}
