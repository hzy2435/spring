package com.spring.hibernate.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.hibernate.service.BookCashier;
import com.spring.hibernate.service.BookService;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;

public class TestHibernate {

	private ApplicationContext ctx = null;
	private BookService service = null;
	private BookCashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (BookService) ctx.getBean("bookService");
		cashier = (BookCashier) ctx.getBean("bookCashier");
	}
	
	@Test
	public void testService() {
		
		service.purcharse("aaa", "10001");
		
	}
	
	@Test
	public void testCashier() {
		
		cashier.checkout("aaa", Arrays.asList("10001", "10002"));
		
	}
	
	@Test
	public void testDataSource() throws SQLException {
		
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
		System.out.println(ds.getConnection());
		
	}
	
}
