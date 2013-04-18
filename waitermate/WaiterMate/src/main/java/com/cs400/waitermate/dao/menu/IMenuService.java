package com.cs400.waitermate.dao.menu;


import java.util.List;
import com.cs400.waitermate.beans.MenuBean;
import com.cs400.waitermate.beans.OrderBean;

import com.cs400.waitermate.beans.MenuBean;

public interface IMenuService {

	public MenuBean loadMenu();
	public String lookupOrderName(OrderBean order);
	Float lookupOrderPrice(OrderBean order);
}
