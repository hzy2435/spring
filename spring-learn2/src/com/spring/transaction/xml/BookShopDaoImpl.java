package com.spring.transaction.xml;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookShopDaoImpl implements BookShopDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int findBookPriceByIsbn(String isbn) {
		
		String sql = "SELECT price FROM t_book WHERE isbn = ?";
		return getJdbcTemplate().queryForObject(sql, Integer.class, isbn);
		
	}

	@Override
	public void updateBookStock(String isbn) {

		String sql = "SELECT stock FROM t_book_stock WHERE isbn = ?";
		Integer stock = getJdbcTemplate().queryForObject(sql, Integer.class, isbn);
		
		if(stock <= 0) {
			throw new BookStockException("库存不足");
		}
		
		sql = "UPDATE t_book_stock SET stock = stock - 1 WHERE isbn = ?";
		getJdbcTemplate().update(sql, isbn);
		
	}

	@Override
	public void updateUserAccount(String username, int price) {

		String sql = "SELECT blance FROM t_account WHERE username = ?";
		Integer blance = getJdbcTemplate().queryForObject(sql, Integer.class, username);
		if(blance < price) {
			throw new UserAccountException("余额不足");
		}
		
		sql = "UPDATE t_account SET blance = blance - ? WHERE username = ?";
		getJdbcTemplate().update(sql, price, username);
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
