package com.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao dao;

	/*
	 * 声明式事务的5个属性: 传播(propagation), 默认为 REQUIRED
	 * 						隔离级别(isolation), 常用的属性值为Isolation.READ_COMMITTED 
	 * 						回滚级别(rollbackFor/noRollbackFor), 默认只回滚所有运行时异常,
	 * 						只读(readOnly), 
	 * 						超时(timeout), 单位为秒. 
	 */
	@Transactional(propagation = Propagation.REQUIRED, 
			isolation = Isolation.READ_COMMITTED, 
			rollbackFor = {Exception.class}, 
			readOnly = false, 
			timeout = 3)
	@Override
	public void purcharse(String username, String isbn) {

		int price = dao.findBookPriceByIsbn(isbn);

		dao.updateBookStock(isbn);
		dao.updateUserAccount(username, price);

	}

}
