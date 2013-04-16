package com.cs400.waitermate.dao.table;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.beans.WaiterBean;
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
	public List<TableBean> getTablesList() {
		List<TableBean> tempBean = getJdbcTemplate().query("SELECT id, waiterId, occupied FROM MyTable", new TableRowMapper());
		return tempBean;
	}

	@Override
	public TableBean getTableById(TableBean table) {
		TableBean tempBean = (TableBean)getJdbcTemplate().queryForObject("SELECT id, waiterId, occupied FROM MyTable WHERE id=?", new Object[]{table.getID()}, new TableRowMapper());
		return tempBean;
	}

	@Override
	public void deleteTable(TableBean table) {
		getJdbcTemplate().update("DELETE FROM MyTable WHERE id=?", new Object[]{table.getID()});		
	}

	@Override
	public void updateTable(TableBean table) {
		getJdbcTemplate().update("UPDATE MyTable SET id=?, waiterId=?, occupied=? WHERE id=?", new Object[]{table.getID(),table.getWaiterID(), table.getOccupied(), table.getID()});
	}

	@Override
	public int getTableCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addTable(TableBean table) {
		getJdbcTemplate().update("INSERT INTO MyTable(id, waiterId, occupied) VALUES(?,?,?)",new Object[]{table.getID(), table.getWaiterID(), table.getOccupied()});		
	}

	@Override
	public List<TableBean> getTablesByWaiter(WaiterBean waiter) {
		List<TableBean> tableList = getJdbcTemplate().query("SELECT id, waiterId, occupied FROM MyTable WHERE waiterId=? AND occupied=1", new Object[]{waiter.getID()}, new TableRowMapper());
		return tableList;
		
	}
	
	

	
}
