package com.cs400.waitermate.dao.check;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.dao.check.CheckRowMapper;
import com.cs400.waitermate.dao.check.ICheckDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class CheckDAOImpl extends JdbcDaoSupport implements ICheckDAO {

	@Override
	public HashMap<String, CheckBean> getChecks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckBean> getCheckList() {
		List<CheckBean> tempBean = getJdbcTemplate().query("SELECT id, tableId, open, subtotal, tip, tax FROM Check", new CheckRowMapper());
		return tempBean;
	}

	@Override
	public CheckBean getCheckById(CheckBean check) {
		CheckBean tempBean = (CheckBean)getJdbcTemplate().queryForObject("SELECT id, tableId, open, subtotal, tip, tax FROM Check WHERE id=?", new Object[]{check.getID()}, new CheckRowMapper());
		return tempBean;
	}

	@Override
	public void deleteCheck(CheckBean check) {
		getJdbcTemplate().update("DELETE FROM Check WHERE id=?", new Object[]{check.getID()});
		
	}

	@Override
	public void updateCheck(CheckBean check) {
		getJdbcTemplate().update("UPDATE Check SET id=?, tableId=?, open=?, subtotal=?, tip=?, tax=? WHERE id=?", new Object[]{ check.getID(), check.getTable(), check.getOpen(), check.getSubtotal(), check.getTip(), check.getTax(), check.getID()});
		
	}

	@Override
	public int getCheckCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addCheck(CheckBean check) {
		getJdbcTemplate().update("INSERT INTO Check(id, tableId, open, subtotal, tip, tax) VALUES(?,?,?,?,?,?)",new Object[]{check.getID(),check.getTable(), check.getOpen(), check.getSubtotal(), check.getTip(), check.getTax()});		
	}

}
