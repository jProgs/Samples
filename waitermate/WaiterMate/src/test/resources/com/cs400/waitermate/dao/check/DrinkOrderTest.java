package com.cs400.waitermate.dao.check;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.DrinkBean;
import com.cs400.waitermate.dao.drinkorder.DrinkOrderDAOImpl;

public class DrinkOrderTest {
  
  @Test
  public void testAddFoodAndRemoveFood(){
    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");

    DrinkBean newDrink = new DrinkBean();
    newDrink.setID(200);
    newDrink.setName("Toilet Water");
    newDrink.setAbv(0);
    newDrink.setCategory("Toiletries");
    newDrink.setPrice(1.0f);
    newDrink.setComment("No poop");
    newDrink.setMenuID(1);
    newDrink.setCheck(1);

    DrinkOrderDAOImpl testService = (DrinkOrderDAOImpl) context.getBean("IDrinkOrderDAO");
    testService.addOrder(newDrink);

   DrinkBean newDrink2= testService.getOrderById(newDrink);

    Assert.assertEquals(true, newDrink.getID() == newDrink2.getID());
    
    List drinkList = new ArrayList<DrinkBean>();
    drinkList = testService.getOrderList();
    
    testService.deleteOrder(newDrink);
    
    List drinkList2 = new ArrayList<DrinkBean>();
    drinkList2 = testService.getOrderList();
    
    Assert.assertEquals(true, drinkList2.size() < drinkList.size());
  }
  
  @Test
  public void testFoodList(){
    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
    
    List drinkList = new ArrayList<DrinkBean>();
    DrinkOrderDAOImpl testService = (DrinkOrderDAOImpl) context.getBean("IDrinkOrderDAO");
    drinkList = testService.getOrderList();
    Assert.assertEquals(true, drinkList.size() > 0);
  }
  
  @Test
  public void testEditTable(){
    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
    
    DrinkOrderDAOImpl testService = (DrinkOrderDAOImpl) context.getBean("IDrinkOrderDAO");
    DrinkBean newDrink = new DrinkBean();
    newDrink.setID(400);
    newDrink.setName("Pig blood");
    newDrink.setAbv(0);
    newDrink.setCategory("Blood");
    newDrink.setPrice(1.0f);
    newDrink.setComment("No bacon");
    newDrink.setMenuID(1);
    newDrink.setCheck(1);
    testService.addOrder(newDrink);
    
    newDrink.setName("Bacon");
    
    testService.updateOrder(newDrink);
    
    DrinkBean testBean = new DrinkBean();
    testBean.setID(200);
    testBean = testService.getOrderById(testBean);
    
    Assert.assertEquals(true, testBean.getName().equals("Bacon"));
    
    testService.deleteOrder(newDrink);
  }
}