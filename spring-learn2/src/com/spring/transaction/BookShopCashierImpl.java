package com.spring.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopCashier")
public class BookShopCashierImpl implements BookShopCashier {

	@Autowired
	private BookShopService service;

	@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {

		for (String isbn : isbns) {
			service.purcharse(username, isbn);
		}

	}

}
