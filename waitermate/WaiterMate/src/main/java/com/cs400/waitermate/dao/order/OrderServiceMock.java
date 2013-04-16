package com.cs400.waitermate.dao.order;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.OrderBean;

public class OrderServiceMock implements IOrderService {

	@Override
	public List<OrderBean> listOrders() {
		List allOrders = new ArrayList<OrderBean>();
		OrderBean ob1 = new OrderBean(1, "Chicken Wrap", new Float(6.99), "Sandwiches", "", 10);
		OrderBean ob2 = new OrderBean(2, "Southwest Burger", new Float(8.99), "Burgers", "Medium Rare", 10);
		OrderBean ob3 = new OrderBean(3, "Tilapia", new Float(6.99), "Fish", "", 14);
		allOrders.add(ob1);
		allOrders.add(ob2);
		allOrders.add(ob3);
		
		return allOrders;
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
		// TODO Auto-generated method stub
		return null;
	}

	

}
