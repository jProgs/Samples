package com.cs400.waitermate.dao.check;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.dao.check.CheckRowMapper;

public class CheckService extends JdbcDaoSupport implements ICheckService {

	@Override
	@SuppressWarnings("unchecked")
	public List<CheckBean> listChecks() {
		List<CheckBean> tempBean = getJdbcTemplate().query("SELECT id, tableId, open, subtotal, tip, tax FROM Check", new CheckRowMapper());
		return tempBean;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void addCheck(CheckBean check) {
		getJdbcTemplate().update("INSERT INTO Check(id, tableId, open, subtotal, tip, tax) VALUES(?,?,?,?,?,?)",new Object[]{check.getID(),check.getTable(), check.getOpen(), check.getSubtotal(), check.getTip(), check.getTax()});
	}

	@Override
	@SuppressWarnings("unchecked")
	public void removeCheck(CheckBean check) {
		getJdbcTemplate().update("DELETE FROM Check WHERE id=?", new Object[]{check.getID()});
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public CheckBean findCheckById(CheckBean check) {
		CheckBean tempBean = (CheckBean)getJdbcTemplate().queryForObject("SELECT id, tableId, open, subtotal, tip, tax FROM Check WHERE id=?", new Object[]{check.getID()}, new CheckRowMapper());
		return tempBean;
	}

	@Override
	public void editCheck(CheckBean check) {
		getJdbcTemplate().update("UPDATE Check SET id=?, tableId=?, open=?, subtotal=?, tip=?, tax=? WHERE id=?", new Object[]{ check.getID(), check.getTable(), check.getOpen(), check.getSubtotal(), check.getTip(), check.getTax(), check.getID()});
	}

	@Override
	public long getNextCheckId() {
		// TODO Figure out how to map results to a long
		long checkID = getJdbcTemplate().query("SELECT MAX(ID) FROM Check");
		return 0;
	}

}
