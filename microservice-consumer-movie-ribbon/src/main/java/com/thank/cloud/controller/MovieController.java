package com.thank.cloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.thank.cloud.entity.ControllerResult;
import com.thank.cloud.entity.User;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBanlancerClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
//		return restTemplate.getForObject("http://localhost:7900/simple/" + id, User.class);
		//VIP (virtual IP)
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	@GetMapping("/test/{id}")
	public User findById2(@PathVariable Long id){
		System.out.println("sss");
		ControllerResult result = this.restTemplate.getForObject("http://microservice-provider-user/simple3/" + id, ControllerResult.class);
		List<User> list = (List<User>) result.getResultList();
		Map<String, User> map = result.getResultMap();
		User oo = (User) result.getObj();
		Map user = (Map) result.getUser();
		return null;
	}
	
	
	@GetMapping("/test")
	public void test(){
		ServiceInstance serviceInstance = this.loadBanlancerClient.choose("microservice-provider-user");
		System.out.println(serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
		
		ServiceInstance serviceInstance2 = this.loadBanlancerClient.choose("microservice-provider-user2");
		System.out.println(serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
	}
}
