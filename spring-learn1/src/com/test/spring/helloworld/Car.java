package com.test.spring.helloworld;

public class Car {

	private String brand;
	private String factory;
	private double price;
	private int speed;

	public Car(String brand, String factory, double price) {
		super();
		this.brand = brand;
		this.factory = factory;
		this.price = price;
	}

	public Car(String brand, String factory, int speed) {
		super();
		this.brand = brand;
		this.factory = factory;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", factory=" + factory + ", price=" + price + ", speed=" + speed + "]";
	}

}
