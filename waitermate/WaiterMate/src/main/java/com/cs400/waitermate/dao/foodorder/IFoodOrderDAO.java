package com.cs400.waitermate.dao.foodorder;

import java.util.List;
import java.util.HashMap;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.FoodBean;

public interface IFoodOrderDAO {
	public void setDataSource (DataSource dataSource);
	public HashMap<String, FoodBean> getOrders();
	public List<FoodBean> getOrderList();
	public FoodBean getOrderById(FoodBean order);
	public void deleteOrder(FoodBean order);
	public void updateOrder(FoodBean order);
	public int getOrderCount();
	public void addOrder(FoodBean order);
	public List<FoodBean> getFoodsListByCheck(CheckBean check);
	long addOrderGetId(FoodBean order);

}
