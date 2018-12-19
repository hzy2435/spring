package com.test.spring.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-generic.xml");

		UserService service = (UserService) ctx.getBean("userService");
		service.add();

	}

}
