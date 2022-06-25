package com.ding.user.service.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author kurt.ding
 * @date 2021/12/23 下午2:14
 */
@FeignClient("order-svc111")
public interface OrderClient {
	@GetMapping("/order")
	String list();
}
