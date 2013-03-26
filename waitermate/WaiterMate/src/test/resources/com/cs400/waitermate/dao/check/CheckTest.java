package com.cs400.waitermate.dao.check;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.dao.check.CheckService;

public class CheckTest {

	@Test
	public void testCheck(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		
		CheckBean testCheck = new CheckBean();
		testCheck.setID(200);
		testCheck.setOpen(true);
		testCheck.setSubtotal(new Float(1.2));
		testCheck.setTable(1);
		testCheck.setTax(new Float(.3));
		testCheck.setTip(new Float(1.0));
		testCheck.setTotal(new Float(2.2));
		
		CheckDAOImpl testService = (CheckDAOImpl) context.getBean("ICheckDAO");
		testService.addCheck(testCheck);
		
		CheckBean testCheck2 = testService.getCheckById(testCheck);
		Assert.assertEquals("200", testCheck2.getID());
	}
}
