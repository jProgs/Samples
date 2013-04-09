package com.cs400.waitermate.dao.menu;

import java.util.List;

import javax.sql.DataSource;

import com.cs400.waitermate.beans.MenuBean;
import com.cs400.waitermate.beans.MenuItemBean;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MenuDAOImpl extends JdbcDaoSupport implements IMenuDAO {

	/*@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void updateMenu(MenuBean menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MenuBean loadMenu() {
		List<MenuItemBean> tempBean = getJdbcTemplate().query("SELECT id, name, price, category FROM MenuItem", new MenuItemRowMapper());
		MenuBean newBean = new MenuBean();
		newBean.setMenu(tempBean);
		return newBean;
	}

}
