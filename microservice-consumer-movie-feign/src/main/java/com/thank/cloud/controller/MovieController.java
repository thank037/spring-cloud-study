package com.thank.cloud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.thank.cloud.UserFeignClient;
import com.thank.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return userFeignClient.findById(id);
	}
	
	@PostMapping("/post-user")
	public User testPostUser(@RequestBody User user){
		return userFeignClient.postUser(user);
	}
	
	
	//不成功, 只能通过2和3这种方式
	@GetMapping("/get-user")
	public User testGetUser(User user){
		return userFeignClient.getUser(user);
	}
	
	@GetMapping("/get-user2")
	public User testGetUser2(User user){
		return userFeignClient.getUser2(user.getId(), user.getName());
	}
	
	@GetMapping("/get-user3")
	public User testGetUser3(User user){
		Map<String, Object> paramMap = Maps.newHashMap();
		paramMap.put("id", user.getId());
		paramMap.put("name", user.getName());
		return userFeignClient.getUser3(paramMap);
	}
}
