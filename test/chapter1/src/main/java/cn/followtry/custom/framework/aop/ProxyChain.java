package cn.followtry.custom.framework.aop;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by followtry on 2017/4/14.
 */
public class ProxyChain {

	private final Class<?> targetClass;

	private final Object targetObject;

	private final Method targetMethod;

	private final MethodProxy methodProxy;

	private final Object[] methodArgs;

	private List<Proxy> proxyList=new ArrayList<>();

	private int proxyIndex = 0;

	public ProxyChain(List<Proxy> proxyList, Object[] methodArgs, MethodProxy methodProxy, Method targetMethod, Object targetObject, Class<?> targetClass) {
		this.proxyList=proxyList;
		this.methodArgs=methodArgs;
		this.methodProxy=methodProxy;
		this.targetMethod=targetMethod;
		this.targetObject=targetObject;
		this.targetClass=targetClass;
	}

	public Class<?> getTargetClass() {
		return targetClass;
	}

	public Method getTargetMethod() {
		return targetMethod;
	}

	public Object[] getMethodArgs() {
		return methodArgs;
	}

	public Object doProxyChain() throws Throwable {
		Object methodResult;

		if (proxyIndex == proxyList.size()) {
			//在proxyIndex未达到代理拦截器集合的上限时，以此获取到proxy并调用其doProxy方法
			methodResult=proxyList.get(proxyIndex++).doProxy(this);
		} else {
			//执行完拦截器后执行目标对象
			methodResult=methodProxy.invokeSuper(targetObject, methodArgs);
		}
		return methodResult;
	}
}
