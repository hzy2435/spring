package com.spring.hibernate.dao;

public interface BookDao {

	int findBookPriceByIsbn(String isbn);
	void updateBookStock(String isbn);
	void updateUserAccount(String username, int price);
	
}
