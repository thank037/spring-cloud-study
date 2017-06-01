package com.thank.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.thank.cloud.entity.User;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/movie/{id}")
	@HystrixCommand(
		fallbackMethod = "findByIdFallback", 
		commandProperties = { @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE") }
	)
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	
	//返回值和参数要和原方法完全一致
	public User findByIdFallback(Long id){
		System.out.println("进入fallback()");
		User user = new User();
		user.setId(0L);
		user.setName("thank");
		return user;
	}
	
}
