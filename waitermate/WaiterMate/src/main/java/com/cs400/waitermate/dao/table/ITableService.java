package com.cs400.waitermate.dao.table;

import java.util.List;

import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.beans.CheckBean;

public interface ITableService {

	public List<TableBean> listTables();
	public void addTable(TableBean table);
	public void removeTable(TableBean table);
	public TableBean findTableById(TableBean table);
	public void editTable(TableBean table);
	//public List<CheckBean>
	public List<CheckBean> getTableCheckList(int tableId);
}
