package com.cs400.waitermate.dao.foodorder;

import java.util.List;
import java.util.ArrayList;

import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.dao.foodorder.IFoodOrderDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class FoodOrderService extends JdbcDaoSupport implements IFoodOrderService {

	private ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
	private IFoodOrderDAO dao = (IFoodOrderDAO) context.getBean("IFoodOrderDAO");
	
	@Override
	public List<FoodBean> listOrders() {
		List<FoodBean> tempbean = new ArrayList<FoodBean>();
		tempbean = dao.getOrderList();
		return tempbean;
	}

	@Override
	public void addOrder(FoodBean order) {
		dao.addOrder(order);	
	}

	@Override
	public void removeOrder(FoodBean order) {
		dao.deleteOrder(order);
	}

	@Override
	public FoodBean findOrdrById(FoodBean order) {
		FoodBean tempBean = dao.getOrderById(order);
		return tempBean;
	}

	@Override
	public void editOrder(FoodBean order) {
		dao.updateOrder(order);
		
	}

	@Override
	public void cancelOrder(long orderId, long checkId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long addOrderGetId(FoodBean order) {
		return dao.addOrderGetId(order);
	}

	@Override
	public void changeToOrderUp(FoodBean fb) {
		dao.changeToOrderUp(fb);
		
	}

}
