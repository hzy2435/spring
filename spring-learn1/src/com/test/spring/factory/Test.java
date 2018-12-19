package com.test.spring.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-factory.xml");

		Car car = (Car) ctx.getBean("cars");
		System.out.println(car);

		Car car1 = (Car) ctx.getBean("car");
		System.out.println(car1);

	}

}
