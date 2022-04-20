package com.ding.spring.hbernate.study.service;

import com.ding.spring.hbernate.study.entity.Person;
import com.ding.spring.hbernate.study.repo.PersonRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author kurt.ding
 * @date 2021/11/17 下午5:39
 */
@Service
@Slf4j
public class PersonService {
	@Autowired
	PersonRepo personRepo;


	@Transactional(readOnly = true)
	public void update(String id) {
		Person person=personRepo.findById(id).map(e -> {
			e.setAge("103");
			return e;
		}).get();
		personRepo.save(person);
	}
	public void save(Person person){
		personRepo.save(person);
	}
}
