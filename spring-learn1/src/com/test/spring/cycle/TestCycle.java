package com.test.spring.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cycle.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
	}

}
