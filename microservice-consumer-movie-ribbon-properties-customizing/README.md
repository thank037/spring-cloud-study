## Ribbon　使用配置文件自定义 

--- 

优先级: 配置文件 > Java程序自定义配置 > 默认配置

要使用Ribbon的配置文件方式: Ribbon的版本要在1.2.0以上.
也就是Camden.SR3及以上

application.yml
```
users:
  ribbon:
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.WeightedResponseTimeRule
```

如何禁用掉Eureka的Ribbon
application.yml
```
ribbon:
  eureka:
   enabled: false
```