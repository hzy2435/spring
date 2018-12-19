package com.test.spring.aop.impl;

import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class ValidateAspect {

	@Before("com.test.spring.aop.impl.LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("--> The method " + methodName + " validate with " + Arrays.asList(joinPoint.getArgs()));
	}
	
}
