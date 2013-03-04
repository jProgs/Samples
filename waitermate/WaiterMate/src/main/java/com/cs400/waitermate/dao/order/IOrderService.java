package com.cs400.waitermate.dao.order;

import java.util.List;
import com.cs400.waitermate.beans.OrderBean;

public interface IOrderService {
	
	public List<OrderBean> listOrders();
	public void addOrder(OrderBean order);
	public void removeOrder(OrderBean order);
	public OrderBean findOrdrById(OrderBean order);
	public void editOrder(OrderBean order);
	public void cancelOrder(long orderId, long checkId);

}
