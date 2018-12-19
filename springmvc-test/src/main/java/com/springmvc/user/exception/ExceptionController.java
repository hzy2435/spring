package com.springmvc.user.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * 使用 SpringMVC 统一处理异常
 */
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NullPointerException.class)
	public String nullablePoint(Exception e) {
		
		System.out.println(e);
		return "result";
		
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public String arithmetic(Exception e) {
		
		System.out.println(e);
		return "result";
		
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		
		System.out.println(e);
		return "result";
		
	}
	
}
