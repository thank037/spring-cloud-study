## Eureka Server 

---

1. 通过http://localhost:8030/hystrix打开dashboard监控窗口 
Ribbon with hystrix
输入地址http://localhost:8901/hystrix.stream
点击Monitor Stream 
注意: 只有访问了该服务API才会出现监控信息. 

Feign with hystrix
同上. 
但需要额外配置
1. pom.xml中必须添加依赖
```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```
2. 启动类需要加@EnableCircuitBreaker注解