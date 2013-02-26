package com.cs400.waitermate.dao.waiter;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;
import com.cs400.waitermate.beans.WaiterBean;


public interface IWaiterDAO {
	
	public void setDataSource (DataSource dataSource);
	
	public HashMap<String, WaiterBean> getWaiters();
	
	public List<WaiterBean> getWaitersList();
	
	public WaiterBean getWaiterById(WaiterBean waiter);
	
	public void deleteWaiter(WaiterBean waiter);
	
	public void updateWaiter(WaiterBean waiter);
	
	public int getWaiterCount();
		
	public void addWaiter(WaiterBean waiter);

}
