package com.cs400.waitermate.dao.table;

import java.util.List;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.beans.WaiterBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.beans.OrderBean;

public class TableServiceMock implements ITableService{

	private static List<TableBean>tables;
	{
		tables = new ArrayList<TableBean>();
		
		// make up tables to be passed around here. 
		
	}
	
	
	@Override
	public List<TableBean> listTables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTable(TableBean table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTable(TableBean table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TableBean findTableById(TableBean table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editTable(TableBean table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CheckBean> getTableCheckList(int tableId) {
		List<CheckBean> checkList = new ArrayList<CheckBean>();
		CheckBean cb1 = new CheckBean(123);
		CheckBean cb2 = new CheckBean(124);
		
		OrderBean ob1 = new OrderBean("chicken");
		OrderBean ob2 = new OrderBean("ham steak");
		
		cb1.addOrder(ob1);
		cb2.addOrder(ob2);
		
		checkList.add(cb1);
		checkList.add(cb2);
		
		return checkList;
	}

	@Override
	public CheckBean getSpecificCheck(long checkId) {
		CheckBean check = new CheckBean();
		return null;
	}

	@Override
	public List<TableBean> getTablesByWaiter(WaiterBean waiter) {
		// TODO Auto-generated method stub
		return null;
	}

}
