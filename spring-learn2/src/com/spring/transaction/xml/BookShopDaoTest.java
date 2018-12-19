package com.spring.transaction.xml;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.transaction.xml.service.BookShopCashier;
import com.spring.transaction.xml.service.BookShopService;

public class BookShopDaoTest {

	private ApplicationContext ctx;
	private BookShopService service;
	private BookShopCashier cashier;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
		service = (BookShopService) ctx.getBean("bookShopService");
		cashier = (BookShopCashier) ctx.getBean("bookShopCashier");
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
