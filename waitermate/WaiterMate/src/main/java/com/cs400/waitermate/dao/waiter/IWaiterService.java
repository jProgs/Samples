package com.cs400.waitermate.dao.waiter;

import java.util.List;
import com.cs400.waitermate.beans.WaiterBean;

public interface IWaiterService {
	
	public List<WaiterBean> listWaiters();
	public void addWaiter(WaiterBean waiter);
	public void reomveWatier(WaiterBean waiter);
	public WaiterBean findWaiterById(WaiterBean waiter);
	public void editWaiter(WaiterBean waiter);
	
	
}
