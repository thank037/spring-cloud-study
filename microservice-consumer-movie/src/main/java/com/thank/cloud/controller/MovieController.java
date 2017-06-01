package com.thank.cloud.controller;

import java.util.Arrays;
import java.util.List;

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
//		return restTemplate.getForObject("http://localhost:7900/simple/" + id, User.class);
		//对于硬编码方式的解决方案一: 把URL放到application.yml中读取
		return restTemplate.getForObject(this.userServicePath + id, User.class);
	}
	
	
	@GetMapping("/user-all")
	public List<User> findAll(){
		
		//这儿有一个坑, 拿List接, User会变成Map
		List<User> userList = restTemplate.getForObject("http://localhost:7901/list-user", List.class);
		
		//要拿User数组去接
		User[] userArrs = restTemplate.getForObject("http://localhost:7901/list-user", User[].class);
		List<User> userList2 = Arrays.asList(userArrs);
		
//		User user1 = userList.get(0);
		User user2 = userList2.get(0);
		System.out.println(user2.getName());
		return userList;
	}
	
}