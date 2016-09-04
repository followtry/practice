/**
 * 
 */
package com.yonyou.test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * java反射的简单练习
 * @author jingzz
 * @time 2016年8月18日 上午9:41:47
 * @name testJar/com.yonyou.test.reflect.ReflectService
 * @since 2016年8月18日 上午9:41:47
 */
public class ReflectService {

	public void sayHello(String name,Integer num) {
		System.out.println("1:hello " + name + ":" +num);
	}
	
	public void sayHello(Integer num,String name) {
		System.out.println("2:hello " + name + ":" +num);
	}
	
	public void sayHello(Integer num) {
		System.out.println("3:hello:" +num);
	}
	
	public void sayHello() {
		System.out.println("4:hello ");
	}


	/**
	 * 封装对反射的调用
	 * @author jingzz
	 * @param <T>
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	protected <T> void invoke(Class<T> cz,String methodName,Object[] values,Class<?>... parameterTypes) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException {
		Class<?> clazz = Class.forName(cz.getCanonicalName());
		T service = (T)clazz.newInstance();
		Method method = service.getClass().getMethod(methodName, parameterTypes);
		method.invoke(service, values);
	}
	
	/**
	 * 反射获取对象实例
	 * @author jingzz
	 * @param cz
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected <T> T getReflectInstance(Class<T> cz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName(cz.getCanonicalName());
		@SuppressWarnings("unchecked")
		T service = (T)clazz.newInstance();
		return service;
	}
}
