package com.cs400.waitermate.dao.check;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cs400.waitermate.beans.WaiterBean;
import com.cs400.waitermate.dao.waiter.WaiterDAOImpl;
import com.cs400.waitermate.dao.waiter.WaiterService;



public class WaiterTest {
	
	@Test
	public void testNewWaiter(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		
		WaiterBean wb = new WaiterBean();
		wb.setAdmin(true);
		wb.setFname("Test");
		wb.setLname("Dummy");
		wb.setID(86980);
		
		testService.addWaiter(wb);
		
		WaiterBean wb2 = new WaiterBean();
		wb2 = testService.getWaiterById(wb);
		
		System.out.println(wb2.getFname());
		System.out.println(wb2.getLname());
		System.out.println(wb2.getID());
				
		Assert.assertEquals("Dummy", wb2.getLname());
		
		testService.deleteWaiter(wb);
	}
	
	@Test
	public void testListWaiters()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		List waiterList = new ArrayList<WaiterBean>();
		waiterList = testService.getWaitersList();
		Assert.assertEquals(true, waiterList.size()>0);	
		
	}
	
	@Test
	public void testRemoveWaiter(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		WaiterBean waiter = new WaiterBean();
		waiter.setID(301);
		waiter.setFname("Bob");
		waiter.setLname("Law");
		waiter.setAdmin(true);		
		testService.addWaiter(waiter);		
		List waiterList1 = new ArrayList<WaiterBean>();
		waiterList1 = testService.getWaitersList();		
		testService.deleteWaiter(waiter);		
		List waiterList2 = new ArrayList<WaiterBean>();
		waiterList2 = testService.getWaitersList();		
		Assert.assertEquals(true, waiterList1.size() > waiterList2.size());
	}
	
	@Test
	public void testFindWaiterById(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		WaiterBean waiter = new WaiterBean();
		waiter.setID(12345);
		WaiterBean waiter2 = new WaiterBean();		
		waiter2 = testService.getWaiterById(waiter);
		
		Assert.assertEquals("Bettger", waiter2.getLname());
	}
	
	@Test
	public void editWaiter(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		WaiterBean waiter = new WaiterBean();
		waiter.setID(12345);
		waiter = testService.getWaiterById(waiter);
		String lname = waiter.getLname();
		waiter.setLname("Nope");
		testService.updateWaiter(waiter);
		WaiterBean waiter2 = new WaiterBean();
		waiter2.setID(12345);
		waiter2 = testService.getWaiterById(waiter2);
		String lname2 = waiter.getLname();
		
		Assert.assertEquals(true, lname != lname2);
		
		waiter.setLname("Bettger");
		testService.updateWaiter(waiter);
		
	}
	
	@Test
	public void testWaiterLogIn(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		WaiterBean waiter = new WaiterBean();
		waiter.setID(12345);
		Assert.assertEquals(true, testService.testWaiterLogIn(waiter));
		
	}
	
	@Test
	public void testWaiterLogInFail(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		WaiterBean waiter = new WaiterBean();
		waiter.setID(99999);
		Assert.assertEquals(false, testService.testWaiterLogIn(waiter));
		
	}

	@Test
	public void testWaiterAdminLogIn(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		WaiterBean waiter = new WaiterBean();
		waiter.setID(12345);
		Assert.assertEquals(true, testService.testWaiterAdminLogIn(waiter));
	}
	
	@Test
	public void testWaiterAdminLogInFail(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		WaiterBean waiter = new WaiterBean();
		waiter.setID(16480);
		Assert.assertEquals(false, testService.testWaiterAdminLogIn(waiter));
	}
	
	
}
