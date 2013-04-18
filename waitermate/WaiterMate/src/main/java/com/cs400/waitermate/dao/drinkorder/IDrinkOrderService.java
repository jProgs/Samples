package com.cs400.waitermate.dao.drinkorder;

import java.util.List;

import com.cs400.waitermate.beans.DrinkBean;

public interface IDrinkOrderService {
	
	public List<DrinkBean> listOrders();
	public void addOrder(DrinkBean order);
	public void removeOrder(DrinkBean order);
	public DrinkBean findOrdrById(DrinkBean order);
	public void editOrder(DrinkBean order);
	public void cancelOrder(long orderId, long checkId);
	public long addOrderGetId(DrinkBean order);
}
