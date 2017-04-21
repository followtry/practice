package cn.followtry.custom.framework.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by followtry on 2017/4/12.
 */
public class ReflectionUtil {
	private static final Logger LOGGER=LoggerFactory.getLogger(ReflectionUtil.class);

	public static Object newInstance(Class<?> clazz) {
		if (clazz != null) {
			Object instance;
			try {
				instance=clazz.newInstance();
			} catch(InstantiationException e) {
				LOGGER.error("new instance failure",e);
				throw new RuntimeException(e);
			} catch(IllegalAccessException e) {
				LOGGER.error("can not access class[{}]:{}",clazz.getCanonicalName(),e);
				throw new RuntimeException(e);
			}
			return instance;
		}
		return null;
	}

	public static Object invokeMethod(Object obj, Method method, Object... args) throws InvocationTargetException, IllegalAccessException {
		makeAccessible(method);
		return method.invoke(obj, args);
	}

	public static void setField(Object obj, Field field, Object value) throws IllegalAccessException {
		makeAccessible(field);
		field.set(obj,value);
	}

	public static void makeAccessible(Field field) {
		if ((!Modifier.isPublic(field.getModifiers()) ||
				!Modifier.isPublic(field.getDeclaringClass().getModifiers()) ||
				Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
			field.setAccessible(true);
		}
	}

	public static void makeAccessible(Method method) {
		if ((!Modifier.isPublic(method.getModifiers()) ||
				!Modifier.isPublic(method.getDeclaringClass().getModifiers())) && !method.isAccessible()) {
			method.setAccessible(true);
		}
	}
}
