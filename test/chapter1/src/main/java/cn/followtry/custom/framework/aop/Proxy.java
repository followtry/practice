package cn.followtry.custom.framework.aop;

/**
 * Created by followtry on 2017/4/14.
 */
public interface Proxy {
	Object doProxy(ProxyChain proxyChain) throws Throwable;
}
