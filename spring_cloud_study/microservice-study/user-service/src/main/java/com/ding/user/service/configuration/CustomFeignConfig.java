package com.ding.user.service.configuration;

import feign.Feign;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kurt.ding
 * @date 2021/12/23 下午3:37
 */
@Configuration
public class CustomFeignConfig {
//	@Bean
//	Feign.Builder feignEnhancers() {
//		return Resilience4jFeign.builder(enhancedDecoratorsBuilder.build());
//	}
}
