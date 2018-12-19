package com.spring.hibernate.service;

import java.util.List;

public interface BookCashier {

	void checkout(String username, List<String> isbns);
	
}
