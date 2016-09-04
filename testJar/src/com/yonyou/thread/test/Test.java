/**
 * 
 */
package com.yonyou.thread.test;

/**
 * @author jingzz
 * @time 2016年7月31日 下午4:27:52
 * @func 
 * @name Test
 */
public class Test {
	public static void main(String[] args) {
//		test();
//		test1();
		threadSafeAndAlive();
		
	}

	/**
	 * 
	 */
	private static void threadSafeAndAlive() {
		MyThread thread = new MyThread();
		Thread thA = new Thread(thread,"A");
		Thread thB = new Thread(thread,"B");
		Thread thC = new Thread(thread,"C");
		System.out.println("thread:"+thread.isAlive());
		System.out.println("thA:"+thA.isAlive());
		System.out.println("thB:"+thB.isAlive());
		System.out.println("thC:"+thC.isAlive());
		thA.start();
		thB.start();
		thC.start();
		System.out.println("thA:"+thA.isAlive());
		System.out.println("thB:"+thB.isAlive());
		System.out.println("thC:"+thC.isAlive());
		System.out.println("thA的唯一id:"+thA.getId());
		System.out.println("thB的唯一id:"+thB.getId());
		System.out.println("thC的唯一id:"+thC.getId());
		System.out.println("是否中断："+thA.isInterrupted());
		System.out.println("是否中断："+thA.interrupted());
	}

	/**
	 * 
	 */
	private static void test1() {
		MyThread thA = new MyThread("A");
		MyThread thB = new MyThread("B");
		MyThread thC = new MyThread("C");
		
		thA.start();
		thB.start();
		thC.start();
	}

	/**
	 * 
	 */
	private static void test() {
		int length = 14;
		for (int i = 0; i < length; i++) {
			MyThread myThread = new MyThread(i);
			myThread.start();
		}
	}
}
