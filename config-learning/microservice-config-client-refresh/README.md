## Spring Cloud Config配置属性刷新(手动刷新)

--- 

1. 获取配置的类中加注解
@RefreshScope

2. pom.xml加入依赖
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

3. 通过POST http://localhost:8041/refresh 刷新端点完成刷新属性配置