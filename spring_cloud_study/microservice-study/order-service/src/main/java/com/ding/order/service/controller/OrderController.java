package com.ding.order.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kurt.ding
 * @date 2021/12/22 下午5:25
 */
@RequestMapping("order")
@RestController
public class OrderController {
	@GetMapping
	public String list() {
		return "SUCCESS111";
	}

}


