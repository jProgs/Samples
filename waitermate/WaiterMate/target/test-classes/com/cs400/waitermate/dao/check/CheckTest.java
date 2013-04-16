package com.cs400.waitermate.dao.check;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.dao.check.CheckService;

public class CheckTest {

	@Test
	public void testNewCheck(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		
		CheckBean testCheck = new CheckBean();
		testCheck.setID(5);
		testCheck.setOpen(true);
		testCheck.setSubtotal(new Float(0));
		testCheck.setTable(1);
		testCheck.setTax(new Float(0));
		testCheck.setTip(new Float(0));
		testCheck.setTotal(new Float(0));
		
		CheckDAOImpl testService = (CheckDAOImpl) context.getBean("ICheckDAO");
		testService.addCheck(testCheck);
		
		CheckBean testCheck2 = testService.getCheckById(testCheck);
		//Assert.assertEquals("200", testCheck2.getID());
		Assert.assertEquals(true, testCheck2.getID() == testCheck.getID());
		
		testService.deleteCheck(testCheck);
	}
	
	
	@Test
	public void testGetCheckList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");		
		List checkList = new ArrayList<CheckBean>();
		CheckDAOImpl testService = (CheckDAOImpl) context.getBean("ICheckDAO");
		checkList = testService.getCheckList();
		Assert.assertEquals(true, checkList.size() > 0);		
	}
	
	@Test
	public void testGetCheckById(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");	
		CheckDAOImpl testService = (CheckDAOImpl) context.getBean("ICheckDAO");
		CheckBean cb = new CheckBean();
		CheckBean check = new CheckBean();
		check.setID(1);
		cb = testService.getCheckById(check);
		System.out.println(cb.getSubtotal());
		
		Assert.assertEquals(true, cb.getSubtotal() == new Float(0));
	}
	
	@Test
	public void testDeleteCheck(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");	
		CheckDAOImpl testService = (CheckDAOImpl) context.getBean("ICheckDAO");
		
	}
	
	@Test
	public void testUpdateCheck(){
		
	}
	
	
	@Test
	public void testGetCheckListByTable(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");	
		CheckDAOImpl testService = (CheckDAOImpl) context.getBean("ICheckDAO");
		TableBean tb = new TableBean();
		tb.setID(1);
		tb.setCheckList(testService.getCheckListByTable(tb));
		
		System.out.println(tb.getCheckList());
		
		for(CheckBean cb: tb.getCheckList()){
			System.out.println(cb.getID() + " ... checkid");
		}
		
		Assert.assertEquals(true, tb.getCheckList().size() > 0);
		
	}
	
	@Test
	public void testSettingCheckList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");	
		CheckDAOImpl testService = (CheckDAOImpl) context.getBean("ICheckDAO");
		TableBean tb = new TableBean();
		tb.setID(1);
		tb.setCheckList(testService.getCheckListByTable(tb));
		System.out.println(tb.getCheckList().size());
		Assert.assertEquals(true, tb.getCheckList().size()>0);
	}
	
	
	
	
}
