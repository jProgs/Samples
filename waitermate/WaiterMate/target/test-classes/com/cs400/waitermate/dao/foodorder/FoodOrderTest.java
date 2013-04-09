package com.cs400.waitermate.dao.foodorder;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.beans.WaiterBean;
import com.cs400.waitermate.dao.waiter.WaiterDAOImpl;

public class FoodOrderTest {

	@Test
	public void testAddFoodOrder(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		
		FoodBean newFood = new FoodBean();
		newFood.setID(200);
		newFood.setName("Chickn");
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

		testService.deleteOrder(newFood);
		
	}
	
}
