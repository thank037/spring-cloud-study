package com.thank.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.thank.cloud.entity.User;
import com.thank.config.FeignTypeConfiguration;

import feign.Param;
import feign.RequestLine;


@FeignClient(name="microservice-provider-user",  configuration=FeignTypeConfiguration.class)
public interface UserFeignClient2 {
	
	/**
	 * configuration中配置了使用Feign的方式. 则必须使用Feign风格的注解
	 */
	//@RequestMapping(value="/simple/{id}", method=RequestMethod.GET)
	 @RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
	
}
