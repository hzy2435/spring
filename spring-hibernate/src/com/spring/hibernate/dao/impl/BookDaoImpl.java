package com.spring.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hibernate.dao.BookDao;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactorty = null;
	
	public Session getSession() {
		
		return sessionFactorty.getCurrentSession();
		
	}
	
	@Override
	public int findBookPriceByIsbn(String isbn) {

		String hql = "select b.price from Book b where b.isbn = ?";
		int price = (int) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		
		return price;
	}

	@Override
	public void updateBookStock(String isbn) {
		
		String hql1 = "select b.stock from Book b where b.isbn = ?";
		int stock = (int) getSession().createQuery(hql1).setString(0, isbn).uniqueResult();
		
		if(stock < 0) {
			System.out.println("库存不足.");
			throw new RuntimeException("库存不足");
		}
		
		hql1 = "update Book b set b.stock = b.stock - 1 where b.isbn = ?";
		getSession().createQuery(hql1).setString(0, isbn).executeUpdate();
		
	}

	@Override
	public void updateUserAccount(String username, int price) {
		
		String hql1 = "select a.blance from Account a where a.accountName = ?";
		int blance = (int) getSession().createQuery(hql1).setString(0, username).uniqueResult();
		
		if(blance < price) {
			System.out.println("余额不足.");
			throw new RuntimeException("余额不足");
		}
		
		hql1 = "update Account a set a.blance = a.blance - ? where a.accountName = ?";
		getSession().createQuery(hql1).setInteger(0, price).setString(1, username).executeUpdate();
	}

}
