package com.thank.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thank.cloud.entity.User;
import com.thank.config.DefaultConfiguration;


@FeignClient(name="microservice-provider-user1", url="http://localhost:7901/", configuration=DefaultConfiguration.class)
public interface UserFeignClient {
	
	/**
	 * configuration不写或者实现为空, 都会使用默认配置. 即使用SpringMVC注解方式
	 */
	@RequestMapping(value="/simple/{id}", method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
}
