package com.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.service.BookCashier;
import com.spring.hibernate.service.BookService;

@Service("bookCashier")
public class BookCashierImpl implements BookCashier {
	
	@Autowired
	private BookService service = null;
	
	@Override
	public void checkout(String username, List<String> isbns) {

		for(String isbn: isbns) {
			
			service.purcharse(username, isbn);
			
		}
		
	}

}
