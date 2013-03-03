package com.cs400.waitermate.dao.waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.cs400.waitermate.beans.WaiterBean;
import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.OrderBean;

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
	public void removeWaiter(WaiterBean waiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WaiterBean findWaiterById(WaiterBean waiter) {
		WaiterBean wb = new WaiterBean(12345, "Joe", "Bettger", false);
		
		TableBean tb1 = new TableBean(1);
		CheckBean cb1 = new CheckBean(1, 100);
		OrderBean ob1 = new OrderBean(cb1.getID(), 1000); 
		
		cb1.addOrder(ob1);
		tb1.addCheckToTable(cb1);		
		wb.addTableToWaiter(tb1);
		
		/*
		TableBean tb2 = new TableBean(2);
		
		CheckBean cb2 = new CheckBean(tb2.getID());
		CheckBean cb3 = new CheckBean(tb2.getID());
		tb1.addCheckToTable(cb1);
		tb2.addCheckToTable(cb2);
		tb2.addCheckToTable(cb3);
		*/
		
		//wb.addTableToWaiter(tb2);
		
		
		return wb;
	}

	@Override
	public void editWaiter(WaiterBean waiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean testWaiterLogIn(WaiterBean waiter) {
		// TODO Auto-generated method stub
		return true;
	}

}
