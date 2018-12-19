package com.test.spring.aop.proxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ArithmeticCalculateLoggingProxy {

	// Ҫ����Ķ���
	private ArithmeticCalculate target;

	public ArithmeticCalculateLoggingProxy(ArithmeticCalculate target) {
		this.target = target;
	}

	public ArithmeticCalculate getProxyInstance() {

		ArithmeticCalculate proxy = null;
		
		// ����������ĸ���������������
		ClassLoader loader = target.getClass().getClassLoader();
		// ������������, ����������Щ����
		Class[] interfaces = new Class[] { ArithmeticCalculate.class };
		// �����ô���������еķ���ʱ, ִ�еĴ���
		InvocationHandler h = new InvocationHandler() {
			/*
			 * proxy: ���ڷ��ص��Ǹ��������, һ�������, �� invoke �����ж���ʹ�øö���
			 * method: ���ڱ����õķ���
			 * args: ���÷���ʱ, ����Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				String methodName = method.getName();
				System.out.println("The method " + methodName + " begin with " + Arrays.asList(args));
				
				Object result = method.invoke(target, args);
				
				System.out.println("The method " + methodName + " end with " + result);
				
				return result;
			}
			
		};
		
		proxy = (ArithmeticCalculate) Proxy.newProxyInstance(loader, interfaces, h);

		return proxy;
	}

}
