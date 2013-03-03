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
		OrderBean ob1 = new OrderBean(658, "Garden Salad",new Float(6.99), "salad", "", cb1.getID()); 
		OrderBean ob2 = new OrderBean(781, "Bison Burger",new Float(8.59) , "hamburger", "no cheese", cb1.getID());
		
		cb1.addOrder(ob1);	
		cb1.addOrder(ob2);
		tb1.addCheckToTable(cb1);
		wb.addTableToWaiter(tb1);
		
		TableBean tb2 = new TableBean(35);
		CheckBean cb2 = new CheckBean(tb2.getID(), 79);
		CheckBean cb3 = new CheckBean(tb2.getID(), 80);
		OrderBean ob3 = new OrderBean(700, "Garden Salad",new Float(6.99), "salad", "", cb2.getID()); 
		OrderBean ob4 = new OrderBean(658, "Buffalo Chicken Sandwich",new Float(7.99), "sandwich", "", cb2.getID()); 
		OrderBean ob5 = new OrderBean(658, "Buffalo Chicken Sandwich",new Float(7.99), "sandwich", "", cb3.getID()); 
		
		cb2.addOrder(ob3);
		cb2.addOrder(ob4);
		cb3.addOrder(ob5);
		tb2.addCheckToTable(cb2);
		tb2.addCheckToTable(cb3);
		wb.addTableToWaiter(tb2);
		
		
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
