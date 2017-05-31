package com.thank.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.thank.cloud.entity.User;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${user.userServicePath}")
	private String userServicePath;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		//return restTemplate.getForObject("http://localhost:7900/simple/" + id, User.class);
		//对于硬编码方式的解决方案一: 把URL放到application.yml中读取
		return restTemplate.getForObject(this.userServicePath + id, User.class);
	}
}
