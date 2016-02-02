﻿
## java排错
### 1. 错误提示：
	org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: Error instantiating class com.skd.domain.User with invalid types () or values (). Cause: java.lang.NoSuchMethodException: com.skd.domain.User.<init>()
		at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:75)
		at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:371)
		at $Proxy14.selectList(Unknown Source)
		at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:198)
		at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:119)
		at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:63)
		at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:52)
		at $Proxy18.getAllUserInfo(Unknown Source)
		at com.skd.service.impl.UserImpl.getAllUserInfo(UserImpl.java:20)
		at com.skd.test.TestService.testGetAllUser(TestService.java:74)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
#### 问题原因和解决方法：
	因为com.skd.domain.User缺少了无参构造方法，添加无参构造方法即可解决问题
	
### 2. 错误：dubbo javassist.ClassPath
	在dubbo启动的过程中报错误：java.lang.ClassNotFoundException: javassist.ClassPath，调试发现代码：Class<?> clazz = Class.forName(line, true, classLoader)执行加载类com.alibaba.dubbo.common.compiler.support.JavassistCompiler时报：java.lang.NoClassDefFoundError: javassist/ClassPath，这个错误最后被加工最终变成上边的错误。可是查看项目下发现依赖的包javassist-3.18.1-GA.jar命名存在，打开这些jar包，其中的javassist.ClassPath的确存在啊，于是我换了个版本javassist-3.18.2-GA.jar程序跑起来了。那么到底是怎么回事呢？。
	其实就是因为JavassistCompile使用了类javassist.ClassPath。经过一点点的比较，最后发现 javassist-3.18.1-GA.jar这个包是有问题的，因为其MAINFEST.FM文件是打不开的，解压以后也报各种Class文件格式错误，看来应该是这个问题了，时间紧张也不打算深入验证了，总之当大家出现这种问题时，也算是一种可能问题吧，希望能为大家解决问题提供线索
**解决办法：**

maven项目中在引入dubbo包的同时还要引入javassist即：依赖包
```xml
	<properties>
	<dubbo.version>2.8.5</dubbo.version>
	<javassist_version>3.15.0-GA</javassist_version>
	</properties>

	<dependencies>
	<dependency>
        <groupId>org.javassist</groupId>
        <artifactId>javassist</artifactId>
        <version>${javassist_version}</version>
    </dependency>
    
	<dependency>
		<groupId>com.alibaba</groupId>
		<artifactId>fastjson</artifactId>
		<version>${fastjson.version}</version>
	</dependency>
	</dependencies>
```
	

### 3. SpringMVC @RequestBody接收Json对象字符串
配置springMVC配置文件,需要的jar包spring-web-4.xx.jar 
```xml
	<bean id="jacksonMessageConverter" class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>
			
	<bean class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
	   <property name="messageConverters">
	      <list>
	         <ref bean="jacksonMessageConverter" />
	      </list>
	   </property>
	</bean>
```
maven中引入依赖：
```xml
	<jackson.version>2.6.1</jackson.version>

	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-core</artifactId>
		<name>Jackson-core</name>
		<version>${jackson.version}</version>
	</dependency>
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-databind</artifactId>
		<version>${jackson.version}</version>
		<name>jackson-databind</name>
	</dependency>
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-annotations</artifactId>
		<name>Jackson-annotations</name>
		<version>${jackson.version}</version>
	</dependency>
	<dependency>
	<groupId>org.codehaus.jackson</groupId>
		<artifactId>jackson-lgpl</artifactId>
		<packaging>jar</packaging>
		<name>Jackson</name>
		<version>0.9.5</version>
	</dependency>

	<dependency>
		<groupId>org.codehaus.jackson</groupId>
		<artifactId>jackson-asl</artifactId>
		<packaging>jar</packaging>
		<name>Jackson</name>
		<version>0.9.5</version>
	</dependency>
```
