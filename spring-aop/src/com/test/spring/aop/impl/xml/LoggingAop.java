package com.test.spring.aop.impl.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAop {
	// 前置通知
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}
	
	// 后置通知: 方法执行后(无论是否发生异常)时执行.
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " is end.");
	}
	
	// 返回通知: 可以访问方法的返回值.
	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	// 异常通知: 可以访问异常对象, 也可以指定异常类型.
//		public void AfterThrowingMethod(JoinPoint joinPoint, NullPointerException e) {
	public void afterThrowingMethod(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occur Exception: " + e);
	}
	
	// 环绕通知: 类似于动态代理, 需要携带 ProceedingJoinPoint 参数, 需要返回值
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		
		Object result = null;
		
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		try {
			// 前置通知
			System.out.println("Around-> The method " + methodName + " begins with " + Arrays.asList(args));
			result = pjp.proceed(args);
			// 返回通知
			System.out.println("Around-> The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			// 异常通知
			System.out.println("Around-> The method " + methodName + " occur exception: " + e);
			throw new RuntimeException(e);
		}
		
		// 后置通知
		System.out.println("Around-> The method " + methodName + " ends.");
		
		return result;
		
	}
}
