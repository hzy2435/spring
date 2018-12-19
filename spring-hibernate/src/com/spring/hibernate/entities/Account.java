package com.spring.hibernate.entities;

public class Account {

	private Integer id;
	private String accountName;
	private int blance;
	
	public Account() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getBlance() {
		return blance;
	}
	public void setBlance(int blance) {
		this.blance = blance;
	}
	
}
