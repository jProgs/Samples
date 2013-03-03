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
		TableBean tb1 = new TableBean(23);
		CheckBean cb1 = new CheckBean(tb1.getID(), 78);
		OrderBean ob1 = new OrderBean(cb1.getID(), 1000); 
		
		cb1.addOrder(ob1);
		System.out.println(cb1.getOrdersList().size() + "orders on check cb1");
		tb1.addCheckToTable(cb1);		
		System.out.println(tb1.getCheckList().size() + "checks on table tb1");
		wb.addTableToWaiter(tb1);
		System.out.println(wb.getCurrentTables().size() + "tables under waiter wb");
		
		System.out.println("IN THE MOCK");
		System.out.println(wb.getLname());
		System.out.println(wb.getCurrentTables().size());
		System.out.println(wb.getCurrentTables().get(0).getID());
		//System.out.println(wb.getCurrentTables().get(0).getCheckList().get(0).getID());
		//System.out.println(wb.getCurrentTables().get(0).getCheckList().get(0).getOrdersList().size());
		System.out.println("END THE MOCK");
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
