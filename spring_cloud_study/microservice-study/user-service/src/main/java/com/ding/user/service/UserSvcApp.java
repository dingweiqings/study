package com.ding.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author kurt.ding
 * @date 2021/12/23 下午2:05
 */
@SpringBootApplication
@EnableFeignClients
public class UserSvcApp {
	public static void main(String[] args) {
		SpringApplication.run(UserSvcApp.class,args);
	}
}
