## Ribbon 

--- 

负载均衡有服务端的负载和客户端的负载, Ribbon属于客户端的负载

1.添加Ribbon依赖
pom文件中Ribbon相关的依赖已经在spring-cloud-starter-eureka下了, 
所以自己可以不用添加了.

2.启动类中: RestTemplate的Bean注入时必须加入@LoadBalanced注解
@Bean
@LoadBalanced
public RestTemplate restTemplate(){
	return new RestTemplate();
}

> 对于之前在MovieController中的硬编码问题: 
	可以通过应用名的方式: 
	将URL: "http://localhost:7900/simple/"  
	替换为"http://microservice-provider-user/simple/"
	注意: 要使用应用名的方式调用, 调用端的启动类中: RestTemplate的Bean注入时必须加入@LoadBalanced注解, 否则不行.

配置完成, 通过启用两个服务提供者(microservice-user)发现, 
服务消费者(microservice-movie-ribbon)通过客户端负载每次命中对方的负载算法是轮询的.

3. 通过代码自定义配置Ribbon
a. 添加TestConfiguration类, 改造ribbonRule()方法. 
```java
@Bean
public IRule ribbonRule() {
	return new RandomRule();
}
```

b.在启动类中添加注解:
```
@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)
```
name和configuration指定对该服务的调用使用该均衡算法.

> **WARNING:** The FooConfiguration has to be @Configuration but take care that it is not in a @ComponentScan for the main application context, otherwise it will be shared by all the @RibbonClients. If you use @ComponentScan (or @SpringBootApplication) you need to take steps to avoid it being included (for instance put it in a separate, non-overlapping package, or specify the packages to scan explicitly in the @ComponentScan).

大概意思是要注意TestConfiguration类的路径, 
该类注解@Configuration是否在主程序@ComponentScan扫描的应用上下文中, 
如果存在当中, 则@RibbonClient会被共享(所有的均衡负载都会使用该@RibbonClient的均衡算法, 
而通常可能我们只需要某个微服务调用的负载使用该@RibbonClient均衡算法).   

解决方式之一是可以将TestConfiguration类放置在@ComponentScan扫不到的地方, 比如上一级.

如果非要放到能扫到的地方, 可以通过自定义一个注解, 从ComponentScan中排除扫描
a. 写一个注解ExcludeFromComponentScan
b. 将该注解加到Ribbon的自定义配置类(TestConfiguration)上
c. 在启动类上加入如下注解排除过滤
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })





