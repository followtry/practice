/**
 * 
 */
package com.yonyou.test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author jingzz
 * @time 2016年8月18日 上午10:18:22
 * @name testJar/com.yonyou.test.reflect.ReflectTest
 * @since 2016年8月18日 上午10:18:22
 */
public class ReflectTest {
	
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		
		
		Object[] values = new Object[2];
		values[0] = "jingzz";
		values[1] = 23;
		ReflectService reflectService = new ReflectService();
		
		/*
		 * 反射方法的调用
		 */
		reflectService.invoke(ReflectService.class,"sayHello",values,String.class,Integer.class);
		reflectService.invoke(ReflectService.class, "sayHello", Arrays.asList(values[1]).toArray(), Integer.class);
		reflectService.invoke(ReflectService.class, "sayHello", null);
		values[1] = "jingzz";
		values[0] = 23;
		reflectService.invoke(ReflectService.class, "sayHello", values, Integer.class,String.class);
		
		/*
		 * 反射生成实例
		 */
		ReflectService reflectInstance = reflectService.getReflectInstance(ReflectService.class);
		reflectInstance.sayHello("this is a reflect obj", 22);
	}
}
