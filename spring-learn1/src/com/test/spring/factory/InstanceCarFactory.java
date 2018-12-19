package com.test.spring.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {

	Map<String, Car> cars = new HashMap<>();

	public InstanceCarFactory() {
		cars.put("audi", new Car("audi", 100000));
		cars.put("ford", new Car("ford", 200000));
	}

	public Car getCar(String brand) {
		return cars.get(brand);
	}

}
