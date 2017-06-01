## 服务消费者(microservice-movie) 

--- 

配置与microservice-user类似.

Controller中的请求方法中: 
@GetMapping("/simple/{id}")
等同: @RequestMapping(value="/simple/{id}", method=RequestMethod.GET) 
	
调用服务提供者(microservice-user)的几个问题:

问题一: 但是如果对方的主机或端口发生变化, 则消费者的配置也需要改变.
可以通过restTemplate调用, 调用地址http://localhost:7900/simple/可以写成硬编码,
也可以配置在application.yml中, 程序中通过@Value("${user.userServicePath}")来取
在没有注册到Eureka上之前可以通过这两种方式.
当服务的提供者和消费者都注册到Eureka: 在调用时可以用应用名(不用写主机地址加端口号)
问题二: 硬编码方式

注意: 
使用RestTemplate类调用其他系统的url的时候，如果加上@LoadBalanced. 
在调用时的url就不能写成IP地址, 要写成应用名


