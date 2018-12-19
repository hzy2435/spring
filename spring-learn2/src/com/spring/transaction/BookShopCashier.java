package com.spring.transaction;

import java.util.List;

public interface BookShopCashier {

	void checkout(String username, List<String> isbns);
	
}
