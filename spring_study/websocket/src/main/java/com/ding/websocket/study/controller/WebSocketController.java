package com.ding.websocket.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author kurt.ding
 * @date 2021/11/7 下午6:06
 */
@Controller
@RequiredArgsConstructor
public class WebSocketController {
	private final Optional<ITestOptionalBean> beanOptional;
	@RequestMapping("/websocket")
	public String getWebSocket() {
		System.out.println(beanOptional.get());
		return "ws-broadcast";
	}
}