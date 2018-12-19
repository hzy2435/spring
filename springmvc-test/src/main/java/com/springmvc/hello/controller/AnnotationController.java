package com.springmvc.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnotationController {

	@RequestMapping("/hello")
	public ModelAndView hello(String name) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", name);
		mav.setViewName("hello");
		
		return mav;
	}
	
}
