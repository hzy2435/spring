package com.springmvc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.user.common.AddressPropertyEditor;
import com.springmvc.user.entities.Address;
import com.springmvc.user.entities.User;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@RequestMapping("/regist")
//	public String regist(@Validated User user, Errors errors) {
	public String regist(User user, Errors errors) {
		
		if(errors.hasErrors()) {
			System.out.println(errors);
			return "regist";
		}
		
		System.out.println("user: " + user);
		return "result";
	}
	
	/*
	 * 注册属性编辑器
	 */
	/*@InitBinder
	public void initBinder(DataBinder binder) {
		binder.registerCustomEditor(Address.class, new AddressPropertyEditor());
	}*/
	
}
