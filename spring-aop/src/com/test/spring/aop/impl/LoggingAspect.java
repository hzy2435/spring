package com.test.spring.aop.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/*
 * ����������Ϊһ������:
 * 1. ��������� IOC ������
 * 2. ����Ϊһ������
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	// �����������ʽ
	@Pointcut("execution(public int com.test.spring.aop.impl.ArithmeticCalculateImpl.*(..))")
	public void declareJoinPointExpression() {}

	// ǰ��֪ͨ
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}
	
	// ����֪ͨ: ����ִ�к�(�����Ƿ����쳣)ʱִ��.
	@After("declareJoinPointExpression()")
	public void AfterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " is end.");
	}
	
	// ����֪ͨ: ���Է��ʷ����ķ���ֵ.
	@AfterReturning(value = "declareJoinPointExpression()",
			returning = "result")
	public void AfterReturningMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	// �쳣֪ͨ: ���Է����쳣����, Ҳ����ָ���쳣����.
	@AfterThrowing(value = "declareJoinPointExpression()",
			throwing = "e")
//	public void AfterThrowingMethod(JoinPoint joinPoint, NullPointerException e) {
	public void AfterThrowingMethod(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occur Exception: " + e);
	}
	
	// ����֪ͨ: �����ڶ�̬����, ��ҪЯ�� ProceedingJoinPoint ����, ��Ҫ����ֵ
	@Around("declareJoinPointExpression()")
	public Object AroundMethod(ProceedingJoinPoint pjp) {
		
		Object result = null;
		
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		try {
			// ǰ��֪ͨ
			System.out.println("Around-> The method " + methodName + " begins with " + Arrays.asList(args));
			result = pjp.proceed(args);
			// ����֪ͨ
			System.out.println("Around-> The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			// �쳣֪ͨ
			System.out.println("Around-> The method " + methodName + " occur exception: " + e);
			throw new RuntimeException(e);
		}
		
		// ����֪ͨ
		System.out.println("Around-> The method " + methodName + " ends.");
		
		return result;
		
	}
	
}
