/**
 * 
 */
package com.yonyou.thread.test;

/**
 * @author jingzz
 * @time 2016年7月31日 下午4:34:24
 * @func 
 * @name Run
 */
public class Run {
	
	public static void main(String[] args) {
		MyRunnable myr = new MyRunnable();
		Thread thread = new Thread(myr);
		thread.start();
		System.out.println("运行结束");
	}
}
