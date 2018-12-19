package com.springmvc.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HelloInterceptor implements HandlerInterceptor {

	// 目标处理方法执行之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler instanceof HandlerMethod) {
			
			HandlerMethod handlerMethod = (HandlerMethod) handler; // handler 本质是一个 HandlerMethod 实例
			Object bean = handlerMethod.getBean(); // 获取处理器对象
			Method method = handlerMethod.getMethod(); // 获取处理器对象的方法.

			System.out.println("HandlerInterceptor.preHandler bean: " + bean + ", method: " + method.getName()
					+ ", args: " + Arrays.asList(method.getParameterTypes()));
		}

		return true;
	}

	// 目标处理方法执行之后, 视图渲染之前
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor.postHandler");
	}

	// 视图渲染之后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor.afterCompletion");
	}

}
