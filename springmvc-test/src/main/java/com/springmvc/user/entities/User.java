package com.springmvc.user.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class User {

	@NotEmpty(message="用户名不能为空")
	@Pattern(regexp="\\w{6,10}", message="用户名只能是6-10位数字, 字母, 下划线")
	private String name;
	
	@Length(min=4, max=10, message="密码必须为4-10位")
	private String password;
	
	@Email(message="邮箱格式不正确")
	private String email;
	
	@Pattern(regexp="(135|139|158)\\d{8}", message="手机号格式不正确")
	private String phone;
	
	@Range(min=1, max=120, message="年龄必须在1-120岁之间")
	private int age;
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email=" + email + ", phone=" + phone + ", age="
				+ age + ", address=" + address + "]";
	}

}
