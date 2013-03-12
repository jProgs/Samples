package com.cs400.waitermate.dao.check;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.cs400.waitermate.beans.CheckBean;

import org.springframework.jdbc.core.RowMapper;

public class CheckRowMapper implements RowMapper{
	@Override
	public CheckBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		CheckBean bean = new CheckBean();
		bean.setID(rs.getLong("id"));
		bean.setTable(rs.getInt("tableId"));
		bean.setOpen(rs.getBoolean("open"));
		bean.setSubtotal(rs.getFloat("subtotal"));
		bean.setTip(rs.getFloat("tip"));
		bean.setTax(rs.getFloat("tax"));
		return bean;
	}
}
