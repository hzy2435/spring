package com.springmvc.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.user.entities.User;

@Controller
@RequestMapping("/session")
@SessionAttributes("user")
public class SessionController {

	@RequestMapping("/step1")
	public String step1() {
		return "step1";
	}
	
	@RequestMapping("/step2")
	public String step2(User user) {
		
		System.out.println(user);
		
		return "step2";
	}
	
	@RequestMapping("/step3")
	public String step3(User user) {
		
		System.out.println(user);
		return "step3";
	}
	
	@RequestMapping("/regist")
	public String regist(User user, HttpSession session) {
		
		System.out.println(session.getAttribute("user"));
		
		System.out.println(user);
		
		return "success";
		
	}
	
}
