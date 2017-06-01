## Eureka Client 

--- 
本文的bootstrap.yml文件中的内容不能放到application.yml中，
因为config部分的配置先于application.yml被加载，
而bootstrap.yml中的配置会先于application.yml加载