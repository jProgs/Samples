package com.cs400.waitermate.dao.drinkorder;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cs400.waitermate.beans.DrinkBean;
import com.cs400.waitermate.dao.drinkorder.IDrinkOrderDAO;

public class DrinkOrderService extends JdbcDaoSupport implements IDrinkOrderService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
	private IDrinkOrderDAO dao = (IDrinkOrderDAO) context.getBean("IDrinkOrderDAO");
	
	@Override
	@SuppressWarnings("unchecked")
	public List<DrinkBean> listOrders() {
		List<DrinkBean> newList = new ArrayList<DrinkBean>();
		newList = dao.getOrderList();
		return newList;
	}

	@Override
	public void addOrder(DrinkBean order) {
		dao.addOrder(order);
	}

	@Override
	public void removeOrder(DrinkBean order) {
		dao.deleteOrder(order);
		
	}

	@Override
	public DrinkBean findOrdrById(DrinkBean order) {
		DrinkBean tempbean = dao.getOrderById(order);
		return tempbean;
		
	}

	@Override
	public void editOrder(DrinkBean order) {
		dao.updateOrder(order);
		
	}

	@Override
	public void cancelOrder(long orderId, long checkId) {
		// TODO Auto-generated method stub
		
	}

}
