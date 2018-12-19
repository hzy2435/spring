package com.test.spring.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext act = new ClassPathXmlApplicationContext("spring-spel.xml");
		Person p = (Person) act.getBean("person");
		System.out.println(p);

	}

}
