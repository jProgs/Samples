package com.cs400.waitermate.dao.menu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cs400.waitermate.beans.MenuBean;
import com.cs400.waitermate.beans.OrderBean;
import com.cs400.waitermate.beans.MenuItemBean;

import java.util.List;
import java.util.ArrayList;


public class MenuService extends JdbcDaoSupport implements IMenuService {

	private ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
	private IMenuDAO dao = (IMenuDAO) context.getBean("IMenuDAO");
	
	private List<MenuItemBean> menu = new ArrayList<MenuItemBean>();
	
	@Override
	public MenuBean loadMenu() { 
		MenuBean tempbean = dao.loadMenu();
		this.menu = tempbean.getMenu();
		return tempbean;
	}

	@Override
	public String lookupOrderName(OrderBean order) {
		for(MenuItemBean mib: this.menu){
			if(order.getMenuID() == mib.getID())
				return mib.getName();
		}
		return "";
		
	}
	
}
