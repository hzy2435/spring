package com.test.spring.aop.impl.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAop {
	// ǰ��֪ͨ
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}
	
	// ����֪ͨ: ����ִ�к�(�����Ƿ����쳣)ʱִ��.
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " is end.");
	}
	
	// ����֪ͨ: ���Է��ʷ����ķ���ֵ.
	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	// �쳣֪ͨ: ���Է����쳣����, Ҳ����ָ���쳣����.
//		public void AfterThrowingMethod(JoinPoint joinPoint, NullPointerException e) {
	public void afterThrowingMethod(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occur Exception: " + e);
	}
	
	// ����֪ͨ: �����ڶ�̬����, ��ҪЯ�� ProceedingJoinPoint ����, ��Ҫ����ֵ
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		
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
