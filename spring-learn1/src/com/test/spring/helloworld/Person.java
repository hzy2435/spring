package com.test.spring.helloworld;

public class Person {

	private String name;

	public Person() {
		System.out.println("Person....");
	}

	public void setName2(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void sayHello() {

		System.out.println("Hello " + name);

	}

}
