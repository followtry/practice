# spring零星笔记
### 1. 注入三种类型
	构造方法注入、属性注入和接口注入    
	
### 2. Spring 资源加载
	Spring提供了强大的加载资源的机制，不但能够通过“classpath:”、“file:”等资源地质前缀识别不同的资源类型，还支持Ant风格带有通配符的资源地址。
	
资源类型的地址前缀：

|地址前缀|示例|对应资源类型|
|------|---|---------|
|classpath:|classpath:com/test/bao/bean.xml|从类路径中加载资源，classpath:和classpath:/是等价的。都是相对于类的根路径。资源文件可以在标准的FS中，也可以在jar或zip的类包中|
|file:|file:/conf/com/test/bao/bean.xml|使用URLResource从FS中加载资源，可采用绝对和相对路径|
|http://|http://www.bao.com/resource/bean.xml|使用URLResource从WEB服务器加载资源|
|ftp://|ftp://www.bao.com/resource.bean.xml|使用URLResource从ftp服务器加载资源|
|没有前缀|com/test/bao/bean.xml|根据applicationContext具体实现类采用对应类型的Resource|

**PS：**

**classpath\*:和classpath:两者比较**:

	"classpath:"只会在第一个加载的com.test.bao包下查找；
	"classpath*:"会扫描到所有的jar包及类路径下出现的com.test.bao包路径
	

**Ant风格资源地址支持3中匹配符**：
	"?":匹配文件中的一个字符
	"\*"：匹配文件名中的任意个字符
	"\*\*":匹配多层路径
	
### 3.加载配置
如果使用web监听器，必须将Log4jConfiglistener放置在ContextLoaderListener前面

如果使用@Configuration的java类提供配置信息，则web.xml配置如下：
```XML
<!-- 通过指定context参数，让spring使用指定的启动器-->
<context-param>
	<param-name>contextClass</param-name>
	<param-value>org.springframework.web.context.support.AnnotatinConfigWebApplicationContext</param-value>
</context-param>
<!-- 标注@Configuration的配置类，多个可以使用逗号或者空格分隔 -->
<context-param>
	<param-name>contextConfigClass</param-name>
	<param-value>com.test.bao.config</param-value>
</context-param>
```





      
















































