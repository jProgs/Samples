package com.cs400.waitermate.dao.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.cs400.waitermate.beans.TableBean;

import org.springframework.jdbc.core.RowMapper;

public class TableRowMapper implements RowMapper{
	@Override
	public TableBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		TableBean bean = new TableBean();
		bean.setID(rs.getInt("id"));
		bean.setOccupied(rs.getBoolean("occupied"));
		bean.setWaiterID(rs.getInt("waiterId"));
		return bean;
	}
}