package com.ding.spring.hbernate.study.controller;

import com.ding.spring.hbernate.study.entity.Child;
import com.ding.spring.hbernate.study.entity.GrandChild;
import com.ding.spring.hbernate.study.entity.Person;
import com.ding.spring.hbernate.study.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kurt.ding
 * @date 2021/11/17 下午5:38
 */
@RestController
@RequestMapping
public class PersonController {
	@Autowired
	PersonService personService;

	@GetMapping("hello:update")
	public String hello() {
		personService.update("1");
		return "SUCCESS";
	}
	@GetMapping("hello:cascadeMultiLevel")
	public void cascadeMultiLevel(){
		Child child = new Child();
		GrandChild grandChild = new GrandChild();
		child.setGrandChildren(grandChild);

		Person person = new Person();
		person.setChilds(child);

		personService.save(person);
	}
	@GetMapping("hello:cascadeMultiLevelQuery")
	public void cascadeMultiLevelQuery(){
		System.out.println(personService.findAll());
	}
}
