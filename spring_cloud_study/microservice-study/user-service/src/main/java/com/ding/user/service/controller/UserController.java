package com.ding.user.service.controller;

import com.ding.user.service.rpc.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kurt.ding
 * @date 2021/12/23 下午2:07
 */
@RequestMapping("user")
@RestController
public class UserController {
	@Autowired
	OrderClient orderClient;
	@GetMapping
	public String list(){
		return "user"+ orderClient.list();
	}
}
