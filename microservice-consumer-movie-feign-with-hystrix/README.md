## Feign对Hystrix的支持

--- 

FeignClient中加入fallback
@FeignClient(name = "microservice-provider-user", fallback=HystrixClientFallback.class)

编写HystrixClientFallback, 实现FeignClient接口
对接口的方法进行fallback方法的实现.