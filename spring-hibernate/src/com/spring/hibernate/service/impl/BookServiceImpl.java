package com.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.dao.BookDao;
import com.spring.hibernate.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao dao = null;

	@Override
	public void purcharse(String username, String isbn) {
		
		int price = dao.findBookPriceByIsbn(isbn);
		dao.updateBookStock(isbn);
		dao.updateUserAccount(username, price);
		
	}

}
