## 通过zuul上传文件

--- 

http://localhost:8050/microservice-file-upload/upload
可以上传文件. 

因为默认使用Spring DispatcherServlet.所以上传服务和zuul本身都有大小限制
1. 在上传服务中添加如下配置:
```yml
spring:
  http:
    multipart:
      max-file-size: 2000Mb
      max-request-size: 2200Mb
```
2. zuul中可以不用配置, 直接在请求URL添加/zuul绕过
如http://localhost:8050/zuul/microservice-file-upload/upload

除此之外还要设置zuul的超时时间:
```yml
#在文件上传时候如果大小较大, 会报Timeout, 所以加入如下配置
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds: 60000
ribbon:
  ConnectTimeout: 3000
  ReadTimeout: 60000
```

