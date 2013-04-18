package com.cs400.waitermate.dao.drinkorder;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import com.cs400.waitermate.beans.DrinkBean;

public class DrinkOrderServiceMock implements IDrinkOrderService {

	@Override
	public List<DrinkBean> listOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrder(DrinkBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(DrinkBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DrinkBean findOrdrById(DrinkBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editOrder(DrinkBean order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(long orderId, long checkId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long addOrderGetId(DrinkBean order) {
		// TODO Auto-generated method stub
		return 0;
	}

}
