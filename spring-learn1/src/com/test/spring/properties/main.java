package com.test.spring.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-properties.xml");
		DataSource ds = (DataSource) ctx.getBean("dataSource");
		System.out.println(ds);

	}

}
