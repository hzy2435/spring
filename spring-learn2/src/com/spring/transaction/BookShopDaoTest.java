package com.spring.transaction;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookShopDaoTest {

	private ApplicationContext ctx;
	private BookShopDao dao;
	private BookShopService service;
	private BookShopCashier cashier;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (BookShopDao) ctx.getBean("bookShopDao");
		service = (BookShopService) ctx.getBean("bookShopService");
		cashier = (BookShopCashier) ctx.getBean("bookShopCashier");
	}
	
	@Test
	public void testFindBookPriceByIsbn() {
		
		System.out.println(dao.findBookPriceByIsbn("10010"));
		
	}
	
	@Test
	public void testUpdateBookStock() {
		
		dao.updateBookStock("10020");
		
	}
	
	@Test
	public void testUpdateUserAccount() {
		
		dao.updateUserAccount("xiaobai", 80);
		
	}
	
	@Test
	public void testBookShopService() {
		
		service.purcharse("xiaobai", "10020");
		
	}
	
	@Test
	public void testBookShopCashier() {
		
		cashier.checkout("xiaobai", Arrays.asList("10010", "10020"));
		
	}
}
