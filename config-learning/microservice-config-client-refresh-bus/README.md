## Spring Cloud Config配置属性刷新(自动刷新)

--- 

准备工作: 

1. 安装RabbitMQ
先安Erlang OTP.exe文件, 再安rabbitmq-server.exe文件
安装完成后就能看到服务里有RabbitMQ, 正在运行中

2. 打开RabbitMQ Command Prompt(sbin dir) 
执行插件: rabbitmq-plugins enable rabbitmq_management
执行完成后即可访问 http://localhost:15672 访问RabbitMQ页面
默认用户名和密码都为guest

---

pom.xml添加依赖:
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```

配置文件中配置rabbitmq信息(host, port, username, password...)


使用POST http://localhost:8041/bus/refresh即可批量完成配置属性更新