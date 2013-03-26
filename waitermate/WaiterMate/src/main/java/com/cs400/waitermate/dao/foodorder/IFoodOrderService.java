package com.cs400.waitermate.dao.foodorder;

import java.util.List;
import com.cs400.waitermate.beans.FoodBean;

public interface IFoodOrderService {
	
	public List<FoodBean> listOrders();
	public void addOrder(FoodBean order);
	public void removeOrder(FoodBean order);
	public FoodBean findOrdrById(FoodBean order);
	public void editOrder(FoodBean order);
	public void cancelOrder(long orderId, long checkId);

}
