package com.cs400.waitermate.dao.table;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.beans.CheckBean;

public class TableService implements ITableService {

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
		// to do
	}

	@Override
	public List<CheckBean> getTableCheckList(int tableId) {
		List<CheckBean> checkList = new ArrayList<CheckBean>();
		
		
		
		
		return checkList;		
	}

}
