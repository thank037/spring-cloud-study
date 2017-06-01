package com.thank.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thank.cloud.entity.User;
import com.thank.cloud.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/simple/{id}")
	//等同: @RequestMapping(value="/simple/{id}", method=RequestMethod.GET)  
	public User findById(@PathVariable Long id){
		return this.userRepository.findOne(id);
	}
}
