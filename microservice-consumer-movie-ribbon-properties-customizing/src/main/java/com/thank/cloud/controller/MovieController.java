package com.thank.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.thank.cloud.entity.User;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBanlancerClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		ServiceInstance serviceInstance = this.loadBanlancerClient.choose("microservice-provider-user");
		System.out.println("－－－" +serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	
	@GetMapping("/test")
	public void test(){
		ServiceInstance serviceInstance = this.loadBanlancerClient.choose("microservice-provider-user");
		System.out.println(serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
	}
}
