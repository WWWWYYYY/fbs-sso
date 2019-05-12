分布式session共享依赖于redis

在/etc/hosts下配置：
127.0.0.1       a.dev.com
127.0.0.1       b.dev.com
127.0.0.1       a.dea.com
127.0.0.1       login.dev.com

使用域名的方式访问网站，例如
http://a.dev.com:8090/index
访问时，若未登录则跳转到http://login.dev.com:8090/toLogin
登录成功后在浏览器下种下父域名dev.com的cookie。
重定向到http://a.dev.com:8090/index，经过拦截器，发现有父域名dev.com的cookie，因此认定已经登录成功了




当前用户如果访问http://b.dev.com:8091/index时，由于父域名dev.com的cookie，因此认定已经登录过了。

重点类：com.enjoy.session.SessionFilter

