package com.cs400.waitermate.dao.check;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.dao.table.TableDAOImpl;

public class TableTest {
	
	@Test
	public void testNewTableAndRemoveTable(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		
		TableBean newTable = new TableBean();
		newTable.setID(100);
		newTable.setOccupied(true);
		newTable.setWaiterID(1);
		
		TableDAOImpl testService = (TableDAOImpl) context.getBean("ITableDAO");
		testService.addTable(newTable);
		
		TableBean table2 = new TableBean();
		table2 = testService.getTableById(newTable);
		
		Assert.assertEquals(table2.getID(), newTable.getID());
		
		List tableList = new ArrayList<TableBean>();
		tableList = testService.getTablesList();
		
		testService.deleteTable(newTable);
		
		List tableList2 = new ArrayList<TableBean>();
		tableList2 = testService.getTablesList();
		
		Assert.assertEquals(tableList2.size() < tableList.size(), true);
	}
	
	@Test
	public void testTableList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		
		List tableList = new ArrayList<TableBean>();
		TableDAOImpl testService = (TableDAOImpl) context.getBean("ITableDAO");
		tableList = testService.getTablesList();
		Assert.assertEquals(true, tableList.size() > 0);
	}
	
	@Test
	public void testEditTable(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		
		TableBean newTable = new TableBean();
		TableDAOImpl testService = (TableDAOImpl) context.getBean("ITableDAO");
		newTable.setID(200);
		newTable.setOccupied(true);
		newTable.setWaiterID(1);
		
		testService.addTable(newTable);
		
		newTable.setOccupied(false);
		
		testService.updateTable(newTable);
		
		TableBean testBean = new TableBean();
		testBean.setID(200);
		testBean = testService.getTableById(testBean);
		
		Assert.assertEquals(true, testBean.getOccupied()==false);
		
		testService.deleteTable(newTable);
	}
	
}
