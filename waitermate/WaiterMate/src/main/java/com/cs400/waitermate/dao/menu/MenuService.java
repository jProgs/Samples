package com.cs400.waitermate.dao.menu;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cs400.waitermate.beans.MenuBean;
import com.cs400.waitermate.dao.menu.MenuItemRowMapper;
import com.cs400.waitermate.beans.MenuItemBean;

public class MenuService extends JdbcDaoSupport implements IMenuService {

	@Override
	public MenuBean loadMenu() { 
		List<MenuItemBean> tempBean = getJdbcTemplate().query("SELECT id, name, price, category FROM MenuItem", new MenuItemRowMapper());
		MenuBean newBean = new MenuBean();
		newBean.setMenu(tempBean);
		return newBean;
	}
	
}
