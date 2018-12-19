package com.spring.transaction.xml.service.impl;

import com.spring.transaction.xml.BookShopDao;
import com.spring.transaction.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao;

	@Override
	public void purcharse(String username, String isbn) {

		int price = getBookShopDao().findBookPriceByIsbn(isbn);

		getBookShopDao().updateBookStock(isbn);
		getBookShopDao().updateUserAccount(username, price);

	}

	public BookShopDao getBookShopDao() {
		return bookShopDao;
	}

	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}

}
