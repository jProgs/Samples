package com.cs400.waitermate.dao.table;

import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;
import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.beans.WaiterBean;

public interface ITableDAO {
	
	public void setDataSource (DataSource dataSource);
	public HashMap<String, TableBean> getTables();
	public List<TableBean> getTablesList();
	public TableBean getTableById(TableBean table);
	public void deleteTable(TableBean table);
	public void updateTable(TableBean table);
	public int getTableCount();
	public void addTable(TableBean table); 
	public List<TableBean> getTablesByWaiter(WaiterBean waiter);
	

}
