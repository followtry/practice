/**
 * 
 */
package com.yonyou.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jingzz
 * @time 2016年8月18日 上午10:24:29
 * @name testJar/com.yonyou.test.proxy.ProxyService
 * @since 2016年8月18日 上午10:24:29
 */
public class ServiceProxy implements InvocationHandler{
	
	private Object target;
	
	@SuppressWarnings("rawtypes")
	public Object bind(Object target,Class... interfaces){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),interfaces, this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("JDK 动态代理");
		Object result = null;
		System.out.println("调用代理前...");
		result = method.invoke(target, args);
		System.out.println("调用代理后...");
 		return result;
	}
	
}
