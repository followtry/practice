package cn.followtry.custom.framework.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by followtry on 2017/4/12.
 */
public class BeanHelper {
	private static final Logger LOGGER=LoggerFactory.getLogger(BeanHelper.class);

	@SuppressWarnings("unchecked")
	private static final Map<Class<?>,Object> BEAN_MAP=new ConcurrentHashMap(){
		{
			ClassHelper.getBeanClassSet().stream().forEach(aClass -> {
				BEAN_MAP.put(aClass, ReflectionUtil.newInstance(aClass));
			});
		}
	};

	public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz){
		if (!BEAN_MAP.containsKey(clazz)) {
			throw new RuntimeException("can not get bean by class name :" + clazz.getCanonicalName());
		}
		return (T) BEAN_MAP.get(clazz);
	}

	/**
	 * 设置bean的实例
	 * @param cls
	 * @param object
	 */
	public static void setBean(Class<?> cls, Object object) {
		BEAN_MAP.put(cls, object);
	}
}
