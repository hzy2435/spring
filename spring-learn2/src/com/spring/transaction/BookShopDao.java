package com.spring.transaction;

public interface BookShopDao {

	int findBookPriceByIsbn(String isbn);
	void updateBookStock(String isbn);
	void updateUserAccount(String username, int price);
	
}
