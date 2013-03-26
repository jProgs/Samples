package com.cs400.waitermate.dao.menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.cs400.waitermate.beans.MenuItemBean;


import org.springframework.jdbc.core.RowMapper;

public class MenuItemRowMapper implements RowMapper{
	@Override
	public MenuItemBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		MenuItemBean bean = new MenuItemBean();
		bean.setID(rs.getInt("id"));
		bean.setName(rs.getString("name"));
		bean.setPrice(rs.getFloat("price"));
		bean.setCategory(rs.getString("category"));
		return bean;
	}
}
