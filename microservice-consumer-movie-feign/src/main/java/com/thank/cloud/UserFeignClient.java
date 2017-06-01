package com.thank.cloud;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thank.cloud.entity.User;


@FeignClient("microservice-provider-user")
public interface UserFeignClient {
	
	@RequestMapping(value="/simple/{id}", method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value="/post-user", method=RequestMethod.POST)
	public User postUser(@RequestBody User user);
	
	
	//该请求不会成功, 只要参数是复杂对象, 即使指定了GET方法, Feign依然会以POST方式进行发送请求.
	//可以通过下面两种方式接参数
	@RequestMapping(value="/get-user", method=RequestMethod.GET)
	public User getUser(User user);
	
	@RequestMapping(value="/get-user", method=RequestMethod.GET)
	public User getUser2(@RequestParam("id") Long id, @RequestParam("name") String name);
	
	@RequestMapping(value="/get-user", method=RequestMethod.GET)
	public User getUser3(@RequestParam Map<String, Object> paramMap);

}
