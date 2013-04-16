package com.cs400.waitermate.dao.check;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.dao.foodorder.FoodOrderDAOImpl;
import com.cs400.waitermate.dao.table.TableDAOImpl;

public class FoodOrderTest {

	@Test
	public void testAddFoodAndRemoveFood(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");

		FoodBean newFood = new FoodBean();
		newFood.setID(9945);
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
		newFood.setID(1119);
		newFood.setName("Chicken and fries");
		newFood.setSideID(1);
		newFood.setCategory("Chicken");
		newFood.setPrice(1.0f);
		newFood.setComment("Needs LESS bacon");
		newFood.setMenuID(1);
		newFood.setCheck(1);

		testService.addOrder(newFood);

		newFood.setComment("Getting Testy");

		testService.updateOrder(newFood);

		FoodBean testBean = new FoodBean();
		testBean.setID(1119);
		FoodBean testBean2 = testService.getOrderById(testBean);
		testService.deleteOrder(newFood);
		Assert.assertEquals("Getting Testy", testBean2.getComment());

		
	}
	
	@Test
	public void testGetFoodListByCheck(){
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
		FoodOrderDAOImpl testService = (FoodOrderDAOImpl) context.getBean("IFoodOrderDAO");
		CheckBean cb = new CheckBean();
		cb.setID(1);
		
		List<FoodBean> foodList = testService.getFoodsListByCheck(cb);
		
		Assert.assertEquals(true, foodList.size() > 0);	
	
	}
}