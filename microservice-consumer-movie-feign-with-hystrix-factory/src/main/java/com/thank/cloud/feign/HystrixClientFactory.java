package com.thank.cloud.feign;

import org.springframework.stereotype.Component;

import com.thank.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient>{

	@Override
	public UserFeignClient create(Throwable cause) {
		System.out.println("====捕获异常日志: " + cause.getMessage());
		return new UserFeignClientWithFactory() {
			
			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				return user;
			}
		};
	}

}
