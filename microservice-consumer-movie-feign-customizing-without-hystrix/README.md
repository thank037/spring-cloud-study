## Feign之禁用掉单个feign client的hystrix支持

--- 

hystrix的粒度可以调整到很细, 可以全局禁用掉, 也可以单独禁用到某个FeignClient
怎么禁用:
configuration配置类中加入
//禁用掉单个feign client的hystrix支持
@Bean
@Scope("prototype")
public Feign.Builder feignBuilder() {
	return Feign.builder();
}