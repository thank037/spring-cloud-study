## Config Server 配置属性加解密(对称加密) 

--- 
下载jce-policy	
http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
替换D:\JDK\jre\lib\security\中的两个文件

仓库中的配置文件: 
例如: 
'profile-dev'字符串通过加密生成密文: 268f87ec6b5cfd46fb020e9db6f93bf1b9992db0da1a55e4e11e8fafddff348f

yml文件
foobar-production.yml
profile: '{cipher}268f87ec6b5cfd46fb020e9db6f93bf1b9992db0da1a55e4e11e8fafddff348f'

properties文件(不带引号)
profile={cipher}268f87ec6b5cfd46fb020e9db6f93bf1b9992db0da1a55e4e11e8fafddff348f

访问URL: 
http://localhost:8040/master/foobar-dev.properties


## Config Server 配置属性加解密(非对称加密) 