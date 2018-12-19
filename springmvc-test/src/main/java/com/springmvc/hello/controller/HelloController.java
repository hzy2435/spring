package com.springmvc.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String name = request.getParameter("name");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", name);
		mav.setViewName("hello");
		
		return mav;
	}

}
