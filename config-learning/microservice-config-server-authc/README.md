## Spring Cloud Config的安全(用户认证)

--- 

1. pom文件中加入如下依赖
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

---

2. application.yml配置:
```
security:
  basic:
    enabled: true
  user:
    name: thank 
    password: 123123
```
如果不加name, password 默认用户名是user, 密码会输出在控制台. 

---

3.config client的两种访问方式 
方式一:在sping.cloud.config.uri 
 = http://thank:123123@localhost:8040 (curl风格)
 
方式二:添加spring.cloud.config.username和spring.cloud.config.password属性
这种方式比uri优先级高

两种方式区别: 
在config与eureka连用时是用服务发现去注册的, 所以没有uri的, 所以只能采用第二种方式