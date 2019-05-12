在/etc/hosts下配置：
127.0.0.1       mm.com
127.0.0.1       bb.com
127.0.0.1       cas.com

使用http://mm.com:8091/index访问，
若未登录则重定向到http://cas.com:8090/toLogin?url=http://mm.com:8091/index
在cas系统上登录成功后重定向到http://mm.com:8091/index?ticket=bbbac336-bc80-4cb4-9892-61d6c674fbee


在同一个浏览器会话上访问http://bb.com:8091/index 认为登录过了



cas解决的就是不同域，同一个用户可以不用重新登录。