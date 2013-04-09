package com.cs400.waitermate.dao.menu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cs400.waitermate.beans.MenuBean;

public class MenuService extends JdbcDaoSupport implements IMenuService {

	private ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
	private IMenuDAO dao = (IMenuDAO) context.getBean("IMenuDAO");
	
	@Override
	public MenuBean loadMenu() { 
		MenuBean tempbean = dao.loadMenu();
		return tempbean;
	}
	
}
