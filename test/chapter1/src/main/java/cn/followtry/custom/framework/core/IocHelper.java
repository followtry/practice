package cn.followtry.custom.framework.core;


import cn.followtry.custom.framework.annotation.Inject;
import org.apache.commons.collections4.MapUtils;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by followtry on 2017/4/12.
 */
public class IocHelper {
	static {
		Map<Class<?>, Object> beanMap=BeanHelper.getBeanMap();
		if (MapUtils.isNotEmpty(beanMap)) {
			for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
				Class<?> beanClass=entry.getKey();
				Object beanInstance=entry.getValue();

				Arrays.stream(beanClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Inject.class)).forEach(field -> {
					Class<?> aClass=field.getType();
					Object instance=beanMap.get(aClass);
					if (instance != null) {
						try {
							ReflectionUtil.setField(beanInstance,field,instance);
						} catch(IllegalAccessException e) {
							throw new RuntimeException(e);
						}
					}
				});
			}
		}
	}
}
