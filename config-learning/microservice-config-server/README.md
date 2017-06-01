## Eureka Server 

--- 
1. pom文件中加入如下依赖
```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```

2. application.yml配置:
```
server:
  port: 8761
```
由于eureka server本身一个是client, 所以也会注册到自己上去.
所以可以加入以下配置来排除自己注册:
```
eureka:
  client: 
    register-with-eureka: false
    fetch-registry: false
```

3. 启动类中加入@EnableEurekaServer注解

---

例如git.oschina.net/it-much/下有一个special目录
special:
 - application.yml
 - special-dev.yml
 - special-test.yml
 
**通配符方式**:
可以把配置目录的名字起的和微服务应用名称一致. 
访问: 
http://localhost:8040/master/special-dev.properties
如果匹配不到就进/special/application.yml找配置
http://localhost:8040/master/special-default.properties


**模式匹配方式**:
simple: 
http://localhost:8040/master/simple-dev.properties
special:
http://localhost:8040/master/special-dev.properties
注意: 
如果匹配不到不会进/special/application.yml找配置, 而是到公用uri里去找
因为模式匹配special.pattern里没有


**搜索路径方式**:
通过文件目录的路径去找相应配置
- foo目录
http://localhost:8040/master/foo-dev.properties


cloneOnStart属性: 
会在启动时检查错误或无效的配置源(例如无效的存储库URI), 
如果为false, 则直到应用程序从该配置源请求配置之前是不会检查错误的.

如果配置仓库是私有的(加密):
加入username, password属性即可