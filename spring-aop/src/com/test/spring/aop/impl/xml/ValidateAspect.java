package com.test.spring.aop.impl.xml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class ValidateAspect {

	public void validateArgs(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("--> The method " + methodName + " validate with " + Arrays.asList(joinPoint.getArgs()));
	}
	
}
