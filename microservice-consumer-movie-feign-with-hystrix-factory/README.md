## Hystrix-FallbackFactory

--- 

FallbackFactory是Camden的新特性, 可以在实现fallback的同时拦截到异常日志.

经过测试fallback与fallbackFactory不能连用
可以理解为fallbackFactory是fallback的增强版, 增强了异常拦截