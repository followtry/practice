package cn.followtry.custom.framework.base;

import cn.followtry.custom.framework.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by followtry on 2017/4/13.
 */
public final class HelperLoader {

	private static final Logger LOGGER=LoggerFactory.getLogger(HelperLoader.class);

	public static void init(){
		Class<?>[] helperList = {
				ClassHelper.class,
				BeanHelper.class,
				AopHelper.class,
				IocHelper.class,
				ControllerHelper.class
		};

		Arrays.stream(helperList).forEach(aClass -> {
			try {
				ClassUtils.loadClass(aClass.getName());
			} catch(ClassNotFoundException e) {
				LOGGER.error("helper类[{}]加载失败，没有找到该类", aClass.getCanonicalName());
				throw new RuntimeException(e);
			}
		});
	}

}
