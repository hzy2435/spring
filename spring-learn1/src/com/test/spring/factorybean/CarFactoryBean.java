package com.test.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

	private String brand;

	/*
	 * ���� bean ʵ��
	 */
	@Override
	public Car getObject() throws Exception {
		return new Car(getBrand(), 180000);
	}

	/*
	 * ���� bean ����
	 */
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
