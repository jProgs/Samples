package com.cs400.waitermate.dao.menu;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import com.cs400.waitermate.beans.MenuBean;

public interface IMenuDAO {
public void setDataSource (DataSource dataSource);
	
	
	public void updateMenu(MenuBean menu);
		
	//public void addWaiter(WaiterBean waiter);
	
	public MenuBean loadMenu();

}
