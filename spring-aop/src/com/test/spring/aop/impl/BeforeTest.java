package com.test.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		
		ArithmeticCalculate arithmeticCalculate = ctx.getBean(ArithmeticCalculate.class);
		
		int result = arithmeticCalculate.add(3, 20);
		System.out.println("--> " + result);
		
		result = arithmeticCalculate.div(10, 2);
		System.out.println("--> " + result);
		
	}
	
}
