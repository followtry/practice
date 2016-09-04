/**
 * 
 */
package com.shiyanlou.java8;

/**
 * @author jingzz
 * @time 2016年8月31日 上午11:08:42
 * @name testJar/com.shiyanlou.java8.MathOperation
 * @since 2016年8月31日 上午11:08:42
 */
@FunctionalInterface
public interface MathOperation {
	
	/*
	 * 函数式接口只能有一个抽象方法，否则会报错
	 */
	
	int operation(int a,int b);
	
//	void sayHello(String message);
}
