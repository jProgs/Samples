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
		wb.setFname("John");
		wb.setLname("Smith");
		wb.setID(75480);
		
		testService.addWaiter(wb);
		
		WaiterBean wb2 = new WaiterBean();
		wb2 = testService.getWaiterById(wb);
		
		System.out.println(wb2.getFname());
		System.out.println(wb2.getLname());
		System.out.println(wb2.getID());
				
		Assert.assertEquals("Smith", wb2.getLname());
	}
	
	@Test
	public void testListWaiters()
	{
		
	}
	
	@Test
	public void testRemoveWaiter(){
		
	}
	
	@Test
	public void testFindWaiterById(){
		
	}
	
	@Test
	public void editWaiter(){
		
	}
	
	@Test
	public void testWaiterLogIn(){
		
	}
	
	@Test
	public void testWaiterLogInFail(){
		
	}

	@Test
	public void testWaiterAdminLogIn(){
		
	}
	
	@Test
	public void testWaiterAdminLogInFail(){
		
	}
	
	
}
