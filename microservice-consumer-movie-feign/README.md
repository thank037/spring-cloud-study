## Feign基本配置

--- 

pom.xml中加入
```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```

启动类中加入@EnableFeignClients注解
编写Feign调用接口UserFeignClient
注解@FeignClient("microservice-provider-user")表明调用的是哪个微服务, 默认该属性是name属性
@FeignClient(name="microservice-provider-user222", url="http://localhost:7901/")
如果存在name和url共存, 则优先找url

注意在Feign调用的的时候有几个坑:
1. FeignClient接口, 不能使用@GetMapping之类的组合注解
       要写成@RequestMapping(value="/xxx", method=RequestMethod.GET)

2. FeignClient接口中, 如果用到@PathVariable, 必须指定其value
       例如不能写成( @PathVariable Long id ), 要写成( @PathVariable("id") Long id )
       
3. FeignClient接口中GET方式多参数的构造
```java
@RequestMapping(value="/get-user", method=RequestMethod.GET)
public User getUser(User user);
```
该请求不会成功, 会报出(405)Method Not Allowe错误
只要参数是复杂对象, 即使指定了GET方法, Feign依然会以POST方式进行发送请求.
解决方式只能通过如下
```
//一:
@RequestMapping(value="/get-user", method=RequestMethod.GET)
public User getUser2(@RequestParam("id") Long id, @RequestParam("name") String name);

//二:
@RequestMapping(value="/get-user", method=RequestMethod.GET)
public User getUser3(@RequestParam Map<String, Object> paramMap);
```
