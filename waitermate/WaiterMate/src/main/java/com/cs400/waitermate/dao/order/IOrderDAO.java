package com.cs400.waitermate.dao.order;

import java.util.List;
import java.util.HashMap;
import javax.sql.DataSource;
import com.cs400.waitermate.beans.OrderBean;

public interface IOrderDAO {
	public void setDataSource (DataSource dataSource);
	public HashMap<String, OrderBean> getOrders();
	public List<OrderBean> getOrderList();
	public OrderBean getOrderById(OrderBean order);
	public void deleteOrder(OrderBean order);
	public void updateOrder(OrderBean order);
	public int getOrderCount();
	public void addOrder(OrderBean order);

}
