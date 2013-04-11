package com.cs400.waitermate.dao.waiter;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.WaiterBean;
import com.cs400.waitermate.dao.waiter.WaiterRowMapper;
import com.cs400.waitermate.dao.waiter.IWaiterDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class WaiterDAOImpl extends JdbcDaoSupport implements IWaiterDAO {

	@Override
	public HashMap<String, WaiterBean> getWaiters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WaiterBean> getWaitersList() {
		List<WaiterBean> tempBean = getJdbcTemplate().query("SELECT id, fName, lName, admin FROM Waiter", new WaiterRowMapper());
		return tempBean;
	}

	@Override
	public WaiterBean getWaiterById(WaiterBean waiter) {
		WaiterBean tempBean = (WaiterBean)getJdbcTemplate().queryForObject("SELECT id, fName, lName, admin FROM Waiter WHERE id=?", new Object[]{waiter.getID()}, new WaiterRowMapper());
		return tempBean;
	}

	@Override
	public void deleteWaiter(WaiterBean waiter) {
		getJdbcTemplate().update("DELETE FROM Waiter WHERE id=?", new Object[]{waiter.getID()});
		
	}

	@Override
	public void updateWaiter(WaiterBean waiter) {
		getJdbcTemplate().update("UPDATE FoodOrder SET id=?, comment=?, check=?, sideId=?, menuId=? WHERE id=?", new Object[]{waiter.getID(),waiter.getFname(), waiter.getLname(), waiter.getAdmin(), waiter.getID()});		
		
	}

	@Override
	public int getWaiterCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addWaiter(WaiterBean waiter) {
		getJdbcTemplate().update("INSERT INTO Waiter(id, fName, lName, admin) VALUES(?,?,?,?)",new Object[]{waiter.getID(),waiter.getFname(), waiter.getLname(), waiter.getAdmin()});				
		
	}

}
