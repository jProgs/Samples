package com.cs400.waitermate.dao.table;

import java.util.List;

import java.util.Date;
import java.util.ArrayList;

import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.dao.foodorder.FoodOrderRowMapper;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TableService extends JdbcDaoSupport implements ITableService {

	@Override
	public List<TableBean> listTables() {
		List<TableBean> tempBean = getJdbcTemplate().query("SELECT id, waiterId, occupied FROM Table", new TableRowMapper());
		return tempBean;
	}

	@Override
	public void addTable(TableBean table) {
		getJdbcTemplate().update("INSERT INTO Table(id, waiterId, occupied) VALUES(?,?,?)",new Object[]{table.getID(), table.getWaiterID(), table.getOccupied()});		

		
	}

	@Override
	public void removeTable(TableBean table) {
		getJdbcTemplate().update("DELETE FROM Table WHERE id=?", new Object[]{table.getID()});		
	}

	@Override
	public TableBean findTableById(TableBean table) {
		TableBean tempBean = (TableBean)getJdbcTemplate().queryForObject("SELECT id, waiterId, occupied FROM Table WHERE id=?", new Object[]{table.getID()}, new TableRowMapper());
		return tempBean;
	}

	@Override
	public void editTable(TableBean table) {
		getJdbcTemplate().update("UPDATE Table SET id=?, waiterId=?, occupied=? WHERE id=?", new Object[]{table.getID(),table.getWaiterID(), table.getOccupied(), table.getID()});
	}

	@Override
	public List<CheckBean> getTableCheckList(int tableId) {
		List<CheckBean> checkList = new ArrayList<CheckBean>();
		
		
		
		
		return checkList;		
	}

	@Override
	public CheckBean getSpecificCheck(long checkId) {
		// TODO Auto-generated method stub
		return null;
	}

}
