package com.cs400.waitermate.dao.table;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.dao.table.TableRowMapper;
import com.cs400.waitermate.dao.table.ITableDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;



public class TableDAOImpl extends JdbcDaoSupport implements ITableDAO {

	@Override
	public HashMap<String, TableBean> getTables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<TableBean> getTablesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableBean getTableById(TableBean table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTable(TableBean table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTable(TableBean table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTableCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addTable(TableBean table) {
		// TODO Auto-generated method stub
		
	}

}
