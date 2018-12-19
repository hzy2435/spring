package com.test.spring.cycle;

import org.springframework.beans.factory.config.BeanPostProcessor;

// ���ô�����
public class BeanPostProcess implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {

		System.out.println("postProcessBeforeInitiation run. bean: " + bean + ", beanName: " + beanName);
		return bean;

	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {

		System.out.println("postProcessAfterInitialization run. bean: " + bean + ", beanName: " + beanName);

		if ("car".equals(beanName)) {
			Car car = new Car();
			car.setBrand("baoma");
			car.setPrice(100000);
			return car;
		}

		return bean;
	}

}
