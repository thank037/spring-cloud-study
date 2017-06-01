package com.thank.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thank.cloud.entity.User;


//fallback与fallbackFactory不能连用
@FeignClient(name = "microservice-provider-user", 
			/*fallback=HystrixClientFallback.class,*/
			fallbackFactory=HystrixClientFactory.class
			)
public interface UserFeignClient {
	
	@RequestMapping(value="/simple/{id}", method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
}
