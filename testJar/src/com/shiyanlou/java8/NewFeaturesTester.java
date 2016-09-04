/**
 * 
 */
package com.shiyanlou.java8;

/**
 * java8特性练习
 * 
 * @author jingzz
 * @time 2016年8月31日 上午11:03:35
 * @name testJar/com.shiyanlou.java8.NewFeaturesTester
 * @since 2016年8月31日 上午11:03:35
 */
public class NewFeaturesTester {

	public NewFeaturesTester() {
	}

	public static void main(String[] args) {
		

		NewFeaturesTester nft = new NewFeaturesTester();
		
		// 带有类型声明的lambda表达式
		MathOperation mathOperation = (int a, int b) -> a + b;

		// 没有类型声明的lambda表达式
		MathOperation mathOperation2 = (a, b) -> a * b;

		// 带有大括号和类型声明的lambda表达式
		MathOperation mathOperation3 = (int a, int b) -> {
			a = a + b;
			return a * b;
		};

		// 带有大括号，没有类型声明的lambda表达式
		MathOperation mathOperation4 = (a, b) -> {
			return a * b;
		};

		System.out.println("a + b :" + nft.operate(12, 23, mathOperation));
		System.out.println("a * b :" + nft.operate(12, 23, mathOperation2));
		System.out.println("( a + b ) * b :" + nft.operate(12, 23, mathOperation3));
		System.out.println("a * b :" + nft.operate(12, 23, mathOperation4));

		// 单参数，无括号无类型的lambda表达式
		GreetingService greetingService = message -> System.out.println("Hello " + message);

		// 单参数，有括号无类型的lambda表达式
		GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);

		// 单参数，有括号有类型的lambda表达式
		GreetingService greetingService3 = (String message) -> System.out.println("Hello " + message);

		greetingService.sayMessage("jingzz");

		greetingService2.sayMessage("xixihaha");

		greetingService3.sayMessage("hehe");

		// lambda表达式实现线程，替代匿名类
		Runnable runnable = () -> System.out.println("Hello I'm a thread.created by lambda");
		new Thread(runnable).start();

		// 匿名类实现的线程
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello I'm a thread.created by java");
			}
		}).start();

	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

}
