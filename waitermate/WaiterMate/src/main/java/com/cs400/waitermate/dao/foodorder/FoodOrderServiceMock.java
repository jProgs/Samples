package com.cs400.waitermate.dao.foodorder;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import com.cs400.waitermate.beans.FoodBean;

public class FoodOrderServiceMock implements IFoodOrderService {

	@Override
	public List<FoodBean> listOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrder(FoodBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(FoodBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FoodBean findOrdrById(FoodBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editOrder(FoodBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(long orderId, long checkId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long addOrderGetId(FoodBean order) {
		// TODO Auto-generated method stub
		return 0;
	}

}
