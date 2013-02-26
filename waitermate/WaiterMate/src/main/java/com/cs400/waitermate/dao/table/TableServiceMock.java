package com.cs400.waitermate.dao.table;

import java.util.List;

import com.cs400.waitermate.beans.TableBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.cs400.waitermate.beans.TableBean;

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

}
