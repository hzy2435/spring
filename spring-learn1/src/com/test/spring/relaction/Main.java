package com.test.spring.relaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.spring.autowired.Car;
import com.test.spring.autowired.Person;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-relaction.xml");
		Car car = (Car) ctx.getBean("car2");
		System.out.println(car);

		Person p = (Person) ctx.getBean("person");
		System.out.println(p);
	}

}
