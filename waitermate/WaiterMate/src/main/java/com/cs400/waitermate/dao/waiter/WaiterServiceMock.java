package com.cs400.waitermate.dao.waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.cs400.waitermate.beans.WaiterBean;

public class WaiterServiceMock implements IWaiterService {

	private static List<WaiterBean>waiters;
	{
		waiters = new ArrayList<WaiterBean>();
		
		// make up waiters to be passed around here. 
		
		
	}
	
	
	
	
	@Override
	public List<WaiterBean> listWaiters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addWaiter(WaiterBean waiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reomveWatier(WaiterBean waiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WaiterBean findWaiterById(WaiterBean waiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editWaiter(WaiterBean waiter) {
		// TODO Auto-generated method stub
		
	}

}
