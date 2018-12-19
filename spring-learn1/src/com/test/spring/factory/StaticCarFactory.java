package com.test.spring.factory;

import java.util.HashMap;
import java.util.Map;

/*
 * ��̬��������
 */
public class StaticCarFactory {

	static Map<String, Car> cars = new HashMap<>();

	static {
		cars.put("audi", new Car("audi", 50000));
		cars.put("baoma", new Car("baoma", 60000));
	}

	public static Car getCar(String brand) {
		return cars.get(brand);
	}

}
