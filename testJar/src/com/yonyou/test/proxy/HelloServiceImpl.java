/**
 * 
 */
package com.yonyou.test.proxy;

/**
 * @author jingzz
 * @time 2016年8月18日 上午10:27:47
 * @name testJar/com.yonyou.test.proxy.HelloServiceImpl
 * @since 2016年8月18日 上午10:27:47
 */
public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello(String name) {
		System.out.println("proxy,hello :"+name);
	}

}
