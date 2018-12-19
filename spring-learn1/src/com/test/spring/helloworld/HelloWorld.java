package com.test.spring.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {

	public static void main(String[] args) {

		// 1. ����Spring��������
		// ���ַ�ʽ��ApplicationContext / BeanContext
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		// 2. ��ȡbean
		Person p = (Person) context.getBean("person");
		p.sayHello();

		Car car1 = (Car) context.getBean("car");
		System.out.println(car1);

		Car car2 = (Car) context.getBean("car2");
		System.out.println(car2);
	}

}
