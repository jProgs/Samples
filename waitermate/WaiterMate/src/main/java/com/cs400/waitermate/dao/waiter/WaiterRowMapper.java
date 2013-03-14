package com.cs400.waitermate.dao.waiter;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.cs400.waitermate.beans.WaiterBean;

import org.springframework.jdbc.core.RowMapper;

public class WaiterRowMapper implements RowMapper{
	public WaiterBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		WaiterBean bean = new WaiterBean();
		bean.setID(rs.getInt("id"));
		bean.setFname(rs.getString("fName"));
		bean.setLname(rs.getString("lName"));
		bean.setAdmin(rs.getBoolean("admin"));
		return bean;
	}
}

