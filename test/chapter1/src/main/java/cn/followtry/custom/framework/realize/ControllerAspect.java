package cn.followtry.custom.framework.realize;

import cn.followtry.custom.framework.annotation.Aspect;
import cn.followtry.custom.framework.annotation.Controller;
import cn.followtry.custom.framework.aop.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 拦截controller的方法
 * Created by followtry on 2017/4/14.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
	private static final Logger LOGGER=LoggerFactory.getLogger(ControllerAspect.class);

	private long begin;

	@Override
	protected void before(Class<?> cls, Method method, Object[] params) {
		LOGGER.info("----------begin---------");
		LOGGER.info("class:{}", cls.getCanonicalName());
		LOGGER.info("method:{}", method.getName());
		begin=System.currentTimeMillis();
	}

	@Override
	protected void after(Class<?> cls, Method method, Object[] params) {
		LOGGER.info("time:{}", (System.currentTimeMillis() - begin));
		LOGGER.info("------end------------");
	}
}
