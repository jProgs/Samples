package com.cs400.waitermate.dao.check;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.dao.foodorder.FoodOrderDAOImpl;
import com.cs400.waitermate.dao.table.TableDAOImpl;

public class FoodOrderTest {
	
	@Test
	public void testAddFoodAndRemoveFood(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");

		FoodBean newFood = new FoodBean();
		newFood.setID(200);
		newFood.setName("Chicken");
		newFood.setSideID(1);
		newFood.setCategory("Chicken");
		newFood.setPrice(1.0f);
		newFood.setComment("Needs bacon");
		newFood.setMenuID(1);
		newFood.setCheck(1);

		FoodOrderDAOImpl testService = (FoodOrderDAOImpl) context.getBean("IFoodOrderDAO");
		testService.addOrder(newFood);

		FoodBean newFood2 = testService.getOrderById(newFood);

		Assert.assertEquals(true, newFood.getID() == newFood2.getID());
		
		List foodList = new ArrayList<FoodBean>();
		foodList = testService.getOrderList();
		
		testService.deleteOrder(newFood);
		
		List foodList2 = new ArrayList<FoodBean>();
		foodList2 = testService.getOrderList();
		
		Assert.assertEquals(true, foodList2.size() < foodList.size());
	}
	
	@Test
	public void testFoodList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		
		List foodList = new ArrayList<FoodBean>();
		FoodOrderDAOImpl testService = (FoodOrderDAOImpl) context.getBean("IFoodOrderDAO");
		foodList = testService.getOrderList();
		Assert.assertEquals(true, foodList.size() > 0);
	}
	
	@Test
	public void testEditTable(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		
		FoodBean newFood = new FoodBean();
		FoodOrderDAOImpl testService = (FoodOrderDAOImpl) context.getBean("IFoodOrderDAO");
		newFood.setID(300);
		newFood.setName("Chicken and fries");
		newFood.setSideID(1);
		newFood.setCategory("Chicken");
		newFood.setPrice(1.0f);
		newFood.setComment("Needs MORE bacon");
		newFood.setMenuID(1);
		newFood.setCheck(1);
		
		testService.addOrder(newFood);
		
		newFood.setName("Bacon");
		
		testService.updateOrder(newFood);
		
		FoodBean testBean = new FoodBean();
		testBean.setID(200);
		testBean = testService.getOrderById(testBean);
		
		Assert.assertEquals(true, testBean.getName().equals("Bacon"));
		
		testService.deleteOrder(newFood);
	}
}
