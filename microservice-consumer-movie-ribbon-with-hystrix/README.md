## Hystrix 

--- 

1. pom.xml中加入依赖:
```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```

2. 启动类中加入@EnableCircuitBreaker注解

3. 加入@HystrixCommand注解, 指定fallback方法(fallback方法返回值和参数要和原方法完全一致 )
