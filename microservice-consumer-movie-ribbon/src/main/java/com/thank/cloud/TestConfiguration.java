package com.thank.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 该类自定义配置Ribbon的均衡算法
 */
@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
	
	/**
	 * 随机均衡算法 
	 */
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
}
