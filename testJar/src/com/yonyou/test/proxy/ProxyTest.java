/**
 * 
 */
package com.yonyou.test.proxy;

/**
 * 动态代理的简单练习
 * @author jingzz
 * @time 2016年8月18日 上午10:57:58
 * @name testJar/com.yonyou.test.proxy.ProxyTest
 * @since 2016年8月18日 上午10:57:58
 */
public class ProxyTest {
	
	public static void main(String[] args) {
		HelloService helloService = new HelloServiceImpl();
		ServiceProxy serviceProxy = new ServiceProxy();
		HelloService service = (HelloService)serviceProxy.bind(helloService, HelloService.class);
		service.sayHello("jingzz");
	}
}
