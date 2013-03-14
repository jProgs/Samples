package com.cs400.waitermate.dao.drinkorder;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.OrderBean;
import com.cs400.waitermate.dao.order.OrderRowMapper;
import com.cs400.waitermate.dao.order.IOrderDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;




public class DrinkOrderDAOImpl extends JdbcDaoSupport implements IDrinkOrderDAO {

	

	@Override
	public HashMap<String, OrderBean> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderBean> getOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderBean getOrderById(OrderBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(OrderBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrder(OrderBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getOrderCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addOrder(OrderBean order) {
		// TODO Auto-generated method stub
		
	}

}
