package com.cs400.waitermate.dao.drinkorder;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.cs400.waitermate.beans.DrinkBean;

import org.springframework.jdbc.core.RowMapper;

public class DrinkOrderRowMapper implements RowMapper{
	@Override
	public DrinkBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		DrinkBean bean = new DrinkBean();
		bean.setID(rs.getLong("id"));
		bean.setCheck(rs.getLong("check"));
		bean.setComment(rs.getString("comment"));
		bean.setAbv(rs.getDouble("abv"));
		bean.setMenuID(rs.getInt("menuId"));
		return bean;
	}
}
