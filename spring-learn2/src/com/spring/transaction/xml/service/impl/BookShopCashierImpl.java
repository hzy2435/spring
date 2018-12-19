package com.spring.transaction.xml.service.impl;

import java.util.List;

import com.spring.transaction.xml.service.BookShopCashier;
import com.spring.transaction.xml.service.BookShopService;

public class BookShopCashierImpl implements BookShopCashier {

	private BookShopService bookShopService;

	@Override
	public void checkout(String username, List<String> isbns) {

		for (String isbn : isbns) {
			getBookShopService().purcharse(username, isbn);
		}

	}

	public BookShopService getBookShopService() {
		return bookShopService;
	}

	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}

}
