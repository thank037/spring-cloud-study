## Feign覆写默认配置

--- 
在Feign的微服务调用接口中:
	configuration不写或者实现为空, 都会使用默认配置. 即使用SpringMVC注解方式
	configuration中如果配置了使用Feign的方式. 则必须使用Feign风格的注解
	
注意一个坑:
	@FeignClient(name="microservice-provider-user1", url="http://localhost:7901/", configuration=DefaultConfiguration.class)
	如果name和url同时存在默认是会找url的. 
	如果有一个以上FeignClient接口. 他俩的url可以相同, confriguration可以相同.
	但是name不能相同, 否则会报出
	ERROR: Method findById not annotated with HTTP method type (ex. GET, POST)

NOTE: 关于configuration配置文件的地方和上节Ribbon有同样的问题, 
就是是否在启动类@ComponentScan的扫描范围内, 如果在就可能冲突.

如果调用是访问Eureka的, 在加了HttpBasic验证的话,
配置文件里加入该配置即可:
```
@Bean
public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor("user", "password");
}
```

### 加入日志
只需两步:
1.application.yml中加入
logging.level.project.user.UserClient: DEBUG
2.配置文件中加入
```
@Configuration
public class FooConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
```


### Feign第一次请求timeout的问题
解决第一次请求报超时异常的方案：
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds: 5000
或者：
hystrix.command.default.execution.timeout.enabled: false
或者：
feign.hystrix.enabled: false ## 索性禁用feign的hystrix支持

