
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

