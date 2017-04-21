package cn.followtry.custom.framework.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by followtry on 2017/4/14.
 */
public abstract class AspectProxy implements Proxy {

	private static final Logger LOGGER= LoggerFactory.getLogger(AspectProxy.class);

	@Override
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		Class<?> targetClass=proxyChain.getTargetClass();
		Object[] methodArgs=proxyChain.getMethodArgs();
		Method targetMethod=proxyChain.getTargetMethod();

		Object result= null;

		begin();

		try {
			if (intercept(targetClass, targetMethod, methodArgs)) {
				before(targetClass, targetMethod, methodArgs);
				result = proxyChain.doProxyChain();
				after(targetClass, targetMethod, methodArgs);
			} else {
				result = proxyChain.doProxyChain();
			}

		}catch(Throwable throwable) {
			LOGGER.error("proxy failure");
			error(targetClass, targetMethod, methodArgs);
			throw throwable;
		}finally {
			end();
		}
		return result;
	}

	protected void begin(){}
	protected void before(Class<?> cls, Method method, Object[] params){}
	protected void after(Class<?> cls, Method method, Object[] params){}
	protected void error(Class<?> cls, Method method, Object[] params){}
	protected void end(){}

	public boolean intercept(Class<?> cls, Method method, Object[] params) {
		return true;
	}



}
