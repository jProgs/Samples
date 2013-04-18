package com.cs400.waitermate.dao.drinkorder;

import java.util.List;
import java.util.HashMap;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.DrinkBean;

public interface IDrinkOrderDAO {
	public void setDataSource (DataSource dataSource);
	public HashMap<String, DrinkBean> getOrders();
	public List<DrinkBean> getOrderList();
	public DrinkBean getOrderById(DrinkBean order);
	public void deleteOrder(DrinkBean order);
	public void updateOrder(DrinkBean order);
	public int getOrderCount();
	public void addOrder(DrinkBean order);
	public List<DrinkBean> getDrinkListByCheck(CheckBean check);
	public long addOrderGetId(DrinkBean order);
}
