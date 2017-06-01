package com.thank.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.thank.cloud.entity.User;
import com.thank.cloud.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return this.userRepository.findOne(id);
	}

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
		return instance.getHomePageUrl();
	}

	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}

	/**
	 * 通过post方式传参获得User 若不传: "status": 400, "error": "Bad Request", message:
	 * "Required request body is missing"
	 * 如果不加@RequestBody, 不会报错, 只是接受到的bo全为null
	 */
	@PostMapping("/post-user")
	public User postUser(@RequestBody User user) {
		return user;
	}

	/**
	 * 通过get方式传参获得User 例如: http://localhost:7901/get-user?name=asd 但是通过Feign不行
	 */
	@GetMapping("/get-user")
	public User getUser(User user) {
		return user;
	}

	@GetMapping("list-user")
	public List<User> listAll() {
		ArrayList<User> list = Lists.newArrayList();
		User user1 = new User();
		User user2 = new User();
		user1.setName("xxx");
		user2.setName("yyy");
		list.add(user1);
		list.add(user2);
		return list;

	}
}
