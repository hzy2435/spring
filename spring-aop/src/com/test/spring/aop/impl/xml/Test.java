package com.test.spring.aop.impl.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-xml.xml");
		ArithmeticCalculate arithmeticCalculate = (ArithmeticCalculate)ctx.getBean("arithmeticCalculate");
		
		int result = arithmeticCalculate.add(10, 19);
		System.out.println("--> " + result);
		
		result = arithmeticCalculate.div(100, 5);
		System.out.println("--> " + result);
		
	}
}
