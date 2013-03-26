package com.cs400.waitermate.dao.waiter;

import java.util.List;

import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.beans.WaiterBean;
import com.cs400.waitermate.dao.foodorder.FoodOrderRowMapper;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class WaiterService extends JdbcDaoSupport implements IWaiterService {

	@Override
	public List<WaiterBean> listWaiters() {
		List<WaiterBean> tempBean = getJdbcTemplate().query("SELECT id, fName, lName, admin FROM Waiter", new WaiterRowMapper());
		return tempBean;
	}

	@Override
	public void addWaiter(WaiterBean waiter) {
		getJdbcTemplate().update("INSERT INTO WaiterOrder(id, fName, lName, admin) VALUES(?,?,?,?)",new Object[]{waiter.getID(),waiter.getFname(), waiter.getLname(), waiter.getAdmin()});				
	}

	@Override
	public void removeWaiter(WaiterBean waiter) {
		getJdbcTemplate().update("DELETE FROM Waiter WHERE id=?", new Object[]{waiter.getID()});
	}

	@Override
	public WaiterBean findWaiterById(WaiterBean waiter) {
		WaiterBean tempBean = (WaiterBean)getJdbcTemplate().queryForObject("SELECT id, fName, lName, admin FROM Waiter WHERE id=?", new Object[]{waiter.getID()}, new WaiterRowMapper());
		return tempBean;
	}

	@Override
	public void editWaiter(WaiterBean waiter) {
		getJdbcTemplate().update("UPDATE FoodOrder SET id=?, comment=?, check=?, sideId=?, menuId=? WHERE id=?", new Object[]{waiter.getID(),waiter.getFname(), waiter.getLname(), waiter.getAdmin(), waiter.getID()});		
	}

	@Override
	public boolean testWaiterLogIn(WaiterBean waiter) {
		// TODO Auto-generated method stub
		return false;
	}

}
