package com.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		
		String sql = "SELECT price FROM t_book WHERE isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		
	}

	@Override
	public void updateBookStock(String isbn) {

		String sql = "SELECT stock FROM t_book_stock WHERE isbn = ?";
		Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		
		if(stock <= 0) {
			throw new BookStockException("库存不足");
		}
		
		sql = "UPDATE t_book_stock SET stock = stock - 1 WHERE isbn = ?";
		jdbcTemplate.update(sql, isbn);
		
	}

	@Override
	public void updateUserAccount(String username, int price) {

		String sql = "SELECT blance FROM t_account WHERE username = ?";
		Integer blance = jdbcTemplate.queryForObject(sql, Integer.class, username);
		if(blance < price) {
			throw new UserAccountException("余额不足");
		}
		
		sql = "UPDATE t_account SET blance = blance - ? WHERE username = ?";
		jdbcTemplate.update(sql, price, username);
		
	}

}
