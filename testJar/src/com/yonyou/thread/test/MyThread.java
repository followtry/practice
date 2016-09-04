/**
 * 
 */
package com.yonyou.thread.test;

/**
 * @author jingzz
 * @time 2016年7月31日 下午4:13:26
 * @func 
 * @name MyThread
 */
public class MyThread extends Thread {
	
	private int i;
	
	private  int count = 5;
	
	public MyThread(int i) {
		this.i = i;
	}
	
	public MyThread(String name) {
		this.setName(name);
	}
	
	public MyThread() {
	}
	
	@Override
	public void run() {
		synchronized (MyThread.class) {
			while(count > 0){
					count--;
				System.out.println("由当前线程"+this.currentThread().getName()+"计算，count="+count);
//				System.out.println("当前线程是否存活："+isAlive());
				
			}
		}
	}

}
