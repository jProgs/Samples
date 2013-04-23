package com.cs400.waitermate.dao.order;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.CheckBean;

import com.cs400.waitermate.beans.DrinkBean;
import com.cs400.waitermate.dao.drinkorder.*;
import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.dao.foodorder.*;
import com.cs400.waitermate.beans.OrderBean;

/*
import com.cs400.waitermate.beans.DrinkBean;
import com.cs400.waitermate.dao.drinkorder.*;
import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.dao.drinkorder.*;
*/



public class OrderService implements IOrderService {


	private ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
	private IFoodOrderDAO foodDAO = (IFoodOrderDAO) context.getBean("IFoodOrderDAO");
	private IDrinkOrderDAO drinkDAO = (IDrinkOrderDAO) context.getBean("IDrinkOrderDAO");
	
	
	@Override
	public List<OrderBean> listOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrder(OrderBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(OrderBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderBean findOrderById(OrderBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editOrder(OrderBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(long orderId, long checkId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderBean> getOrdersByCheck(CheckBean check) {
		 List<DrinkBean> drinks = new ArrayList<DrinkBean>();
		 List<FoodBean> foods = new ArrayList<FoodBean>();
		 List<OrderBean> allOrdersList = new ArrayList<OrderBean>();
		 
		 drinks = drinkDAO.getDrinkListByCheck(check);
		 foods = foodDAO.getFoodsListByCheck(check);
		 //allOrdersList = drinks;
		 
		 for(DrinkBean db: drinks){			
			 allOrdersList.add(db);			 
		 }
		 
		 for(FoodBean fb: foods){
			 allOrdersList.add(fb);
		 }
		 System.out.println("in mothe rfucking order service");
		 System.out.println(allOrdersList.toString() + allOrdersList.size());
		 return allOrdersList;
	}

}
