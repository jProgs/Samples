package com.cs400.waitermate.dao.waiter;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.WaiterBean;

public class WaiterTest {
	
	@Test
	public void testNewWaiter(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		
		WaiterBean newWaiter = new WaiterBean();
		newWaiter.setID(200);
		newWaiter.setFname("George");
		newWaiter.setLname("Georgio");
		newWaiter.setAdmin(true);
		
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		testService.addWaiter(newWaiter);
		
		WaiterBean newWaiter2 = testService.getWaiterById(newWaiter);
		
		Assert.assertEquals(true, newWaiter.getID() == newWaiter2.getID());

		testService.deleteWaiter(newWaiter);
		
	}
	
	@Test
	public void testGetWaiterList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");		
		List waiterList = new ArrayList<WaiterBean>();
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		waiterList = testService.getWaitersList();
		Assert.assertEquals(true, waiterList.size() > 0);		
	}
	
	@Test
	public void testDeleteWaiter(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterBean newWaiter = new WaiterBean();
		newWaiter.setID(300);
		newWaiter.setFname("Bob");
		newWaiter.setLname("Loblaw");
		newWaiter.setAdmin(true);
		
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		testService.addWaiter(newWaiter);
		
		List waiterList1 = new ArrayList<WaiterBean>();
		waiterList1 = testService.getWaitersList();
		
		testService.deleteWaiter(newWaiter);
		
		List waiterList2 = new ArrayList<WaiterBean>();
		waiterList2 = testService.getWaitersList();
		
		Assert.assertEquals(true, waiterList1.size() > waiterList2.size());
	}
	
	@Test
	public void testUpdateWaiter(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		WaiterBean newWaiter = new WaiterBean();
		newWaiter.setID(400);
		newWaiter.setFname("Jim");
		newWaiter.setLname("Slim");
		newWaiter.setAdmin(true);
		
		WaiterDAOImpl testService = (WaiterDAOImpl) context.getBean("IWaiterDAO");
		testService.addWaiter(newWaiter);
		
		newWaiter.setFname("Slim");
		newWaiter.setLname("Jim");
		
		testService.updateWaiter(newWaiter);
		
		Assert.assertEquals("Slim", newWaiter.getFname());
		
		testService.deleteWaiter(newWaiter);
	}
	
}
