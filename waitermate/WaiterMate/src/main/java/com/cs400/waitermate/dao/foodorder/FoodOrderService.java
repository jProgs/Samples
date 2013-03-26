package com.cs400.waitermate.dao.foodorder;

import java.util.List;
import java.util.ArrayList;

import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.dao.foodorder.FoodOrderRowMapper;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class FoodOrderService extends JdbcDaoSupport implements IFoodOrderService {

	@Override
	public List<FoodBean> listOrders() {
		List<FoodBean> tempBean = getJdbcTemplate().query("SELECT id, menuId, comment, check, sideId FROM FoodOrder", new FoodOrderRowMapper());
		return tempBean;
	}

	@Override
	public void addOrder(FoodBean order) {
		getJdbcTemplate().update("INSERT INTO FoodOrder(id, comment, check, sideId, menuId) VALUES(?,?,?,?,?)",new Object[]{order.getID(),order.getComment(), order.getCheck(), order.getSideID(), order.getMenuID()});		
	}

	@Override
	public void removeOrder(FoodBean order) {
		getJdbcTemplate().update("DELETE FROM FoodOrder WHERE id=?", new Object[]{order.getID()});
	}

	@Override
	public FoodBean findOrdrById(FoodBean order) {
		FoodBean tempBean = (FoodBean)getJdbcTemplate().queryForObject("SELECT id, comment, check, sideId, menuId FROM FoodOrder WHERE id=?", new Object[]{order.getID()}, new FoodOrderRowMapper());
		return tempBean;
	}

	@Override
	public void editOrder(FoodBean order) {
		getJdbcTemplate().update("UPDATE FoodOrder SET id=?, comment=?, check=?, sideId=?, menuId=? WHERE id=?", new Object[]{order.getID(),order.getComment(), order.getCheck(), order.getSideID(), order.getMenuID(), order.getID()});
		
	}

	@Override
	public void cancelOrder(long orderId, long checkId) {
		// TODO Auto-generated method stub
		
	}

}
