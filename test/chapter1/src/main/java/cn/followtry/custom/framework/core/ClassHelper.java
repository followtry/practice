package cn.followtry.custom.framework.core;

import cn.followtry.custom.framework.annotation.Controller;
import cn.followtry.custom.framework.annotation.Service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by followtry on 2017/4/12.
 */
public class ClassHelper {

	private static final Set<Class<?>> CLASS_SET;

	static {
		String basePackage=ConfigHelper.getAppBasePackage();
		try {
			CLASS_SET=ClassUtils.getAllClasses(basePackage);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static Set<Class<?>> getClassSet() {
		return CLASS_SET;
	}

	public static Set<Class<?>> getServiceClassSet() {
		if (CLASS_SET != null) {
			Set<Class<?>> classSet=CLASS_SET.stream().filter(aClass -> aClass.isAnnotationPresent(Service.class)).collect(Collectors.toSet());
			return classSet == null ? Collections.EMPTY_SET : classSet;
		}
		return Collections.emptySet();
	}

	public static Set<Class<?>> getControllerClassSet() {
		if (CLASS_SET != null) {
			Set<Class<?>> classSet=CLASS_SET.stream().filter(aClass -> aClass.isAnnotationPresent(Controller.class)).collect(Collectors.toSet());
			return classSet == null ? Collections.EMPTY_SET : classSet;
		}
		return Collections.emptySet();
	}

	public static Set<Class<?>> getBeanClassSet() {

		return new HashSet<Class<?>>() {
			{
				addAll(getServiceClassSet());
				addAll(getControllerClassSet());
			}
		};
	}

	/**
	 *  获取应用包名下，某父类的所有子类
	 * @param superClass
	 * @return
	 */
	public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
		Set<Class<?>> classSet=CLASS_SET.stream()
				.filter(cls -> superClass.isAssignableFrom(cls))
				.filter(cls -> !superClass.equals(cls))
				.collect(Collectors.toSet());
		return classSet == null ? Collections.emptySet() : classSet;
	}

	/**
	 * 获取应用包名下带有某注解的所有类
	 * @param annoClass
	 * @return
	 */
	public static Set<Class<?>> getClassSetByAnno(Class<? extends Annotation> annoClass) {
		Set<Class<?>> classSet=CLASS_SET.stream()
				.filter(aClass -> aClass.isAnnotationPresent(annoClass))
				.collect(Collectors.toSet());
		return classSet == null ? Collections.emptySet() : classSet;
	}

}
