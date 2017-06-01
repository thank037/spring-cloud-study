package com.thank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Contract;
import feign.Feign;

@Configuration
public class FeignTypeConfiguration {

	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}

	//禁用掉单个feign client的hystrix支持
	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
}
