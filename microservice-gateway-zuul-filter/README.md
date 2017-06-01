## Zuul filter

--- 
1. 编写PreZuulFilter继承ZuulFilter即可
可以参考org.springframework.cloud.netflix.zuul.filters中提供的过滤器

2. 禁用zull的过滤器
> For example to disable org.springframework.cloud.netflix.zuul.filters.post.SendResponseFilter 
> set zuul.SendResponseFilter.post.disable=true.