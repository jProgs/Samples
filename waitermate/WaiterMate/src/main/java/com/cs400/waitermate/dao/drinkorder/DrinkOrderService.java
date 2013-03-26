package com.cs400.waitermate.dao.drinkorder;

import java.util.List;
import java.util.ArrayList;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.OrderBean;
import com.cs400.waitermate.beans.DrinkBean;
import com.cs400.waitermate.dao.check.CheckRowMapper;
import com.cs400.waitermate.dao.drinkorder.DrinkOrderRowMapper;

public class DrinkOrderService extends JdbcDaoSupport implements IDrinkOrderService {

	@Override
	@SuppressWarnings("unchecked")
	public List<DrinkBean> listOrders() {
		List<DrinkBean> tempBean = getJdbcTemplate().query("SELECT id, comment, check, abv, menuId FROM DrinkOrder", new DrinkOrderRowMapper());
		return tempBean;
	}

	@Override
	public void addOrder(DrinkBean order) {
		getJdbcTemplate().update("INSERT INTO DrinkOrder(id, comment, check, abv, menuId) VALUES(?,?,?,?,?)",new Object[]{order.getID(),order.getComment(), order.getCheck(), order.getAbv(), order.getMenuID()});
		
	}

	@Override
	public void removeOrder(DrinkBean order) {
		getJdbcTemplate().update("DELETE FROM DrinkOrder WHERE id=?", new Object[]{order.getID()});
		
	}

	@Override
	public DrinkBean findOrdrById(DrinkBean order) {
		DrinkBean tempBean = (DrinkBean)getJdbcTemplate().queryForObject("SELECT id, comment, check, abv, menuId FROM DrinkOrder WHERE id=?", new Object[]{order.getID()}, new DrinkOrderRowMapper());
		return tempBean;
		
	}

	@Override
	public void editOrder(DrinkBean order) {
		getJdbcTemplate().update("UPDATE DrinkOrder SET id=?, comment=?, check=?, abv=?, menuId=? WHERE id=?", new Object[]{order.getID(),order.getComment(), order.getCheck(), order.getAbv(), order.getMenuID(), order.getID()});
		
	}

	@Override
	public void cancelOrder(long orderId, long checkId) {
		// TODO Auto-generated method stub
		
	}

}
