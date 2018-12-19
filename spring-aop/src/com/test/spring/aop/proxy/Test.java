package com.test.spring.aop.proxy;

public class Test {

	public static void main(String[] args) {
		
		ArithmeticCalculate target = new ArithmeticCalculateImpl();
		ArithmeticCalculate proxy = new ArithmeticCalculateLoggingProxy(target).getProxyInstance();
		
		int result = proxy.add(2, 6);
		System.out.println("--> " + result);
		result = proxy.div(10, 2);
		System.out.println("--> " + result);
		
	}
	
}
