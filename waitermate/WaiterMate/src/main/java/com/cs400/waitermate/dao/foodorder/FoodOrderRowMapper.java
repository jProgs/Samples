package com.cs400.waitermate.dao.foodorder;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.cs400.waitermate.beans.FoodBean;

import org.springframework.jdbc.core.RowMapper;

public class FoodOrderRowMapper implements RowMapper{
	@Override
	public FoodBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		FoodBean bean = new FoodBean();
		bean.setID(rs.getLong("id"));
		bean.setCheck(rs.getLong("mycheck"));
		bean.setComment(rs.getString("comments"));
		bean.setSideID(rs.getInt("sideId"));
		bean.setMenuID(rs.getInt("menuId"));
		return bean;
	}
}
