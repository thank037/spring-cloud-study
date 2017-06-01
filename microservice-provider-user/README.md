## 服务提供者(microservice-user)

--- 

注册到Eureka中: 
1. pom文件中加入如下依赖
```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```

2. application.yml配置:
```
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
  instance:
    prefer-ip-address: true #实例名称显示IP
    instance-id: ${spring.application.name}:${spring.cloud.client.ipAddress}:${spring.application.instance_id:${server.port}} #定制实例名
```
可以通过instance-id自己定制实例名称: 
instance-id: ${spring.application.name}:${spring.cloud.client.ipAddress}:${spring.application.instance_id:${server.port}} 
如果Eureka中加入了安全登陆的验证, 这里的defaultZone就要写成http://user:password@localhost:8761/eureka

3. 启动类中加入@EnableEurekaClient注解
@EnableDiscoveryClient 也可以, 还适用于其他服务发现, 如Consul