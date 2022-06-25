package com.ding.spring.hbernate.study.repo;

import com.ding.spring.hbernate.study.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kurt.ding
 * @date 2021/11/17 下午5:37
 */
public interface PersonRepo extends JpaRepository<Person,String> {
}
