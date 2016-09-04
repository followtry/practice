package com.yonyou.test;

import java.util.HashMap;

public class HashMapTest2 {
	public static void main(String[] args) throws InterruptedException {
		HashMap<Object, Object> map = new HashMap<Object,Object>();
		for (double i = 0; i < 10000; i++) {
			map.put(i, i);
		}
		int maxValue = Integer.MAX_VALUE;//2147483647
		long maxValue2 = Long.MAX_VALUE;//9223372036854775807 
		System.out.println("结束");
	}
}
