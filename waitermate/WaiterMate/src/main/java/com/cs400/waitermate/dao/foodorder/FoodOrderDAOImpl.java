package com.cs400.waitermate.dao.foodorder;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.FoodBean;
import org.springframework.jdbc.core.support.JdbcDaoSupport;




public class FoodOrderDAOImpl extends JdbcDaoSupport implements IFoodOrderDAO {

	

	@Override
	public HashMap<String, FoodBean> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodBean> getOrderList() {
		List<FoodBean> tempBean = getJdbcTemplate().query("SELECT id, menuId, comments, mycheck, sideId FROM FoodOrder", new FoodOrderRowMapper());
		return tempBean;
	}

	@Override
	public FoodBean getOrderById(FoodBean order) {
		FoodBean tempBean = (FoodBean)getJdbcTemplate().queryForObject("SELECT id, comments, mycheck, sideId, menuId FROM FoodOrder WHERE id=?", new Object[]{order.getID()}, new FoodOrderRowMapper());
		return tempBean;
	}

	@Override
	public void deleteOrder(FoodBean order) {
		getJdbcTemplate().update("DELETE FROM FoodOrder WHERE id=?", new Object[]{order.getID()});
	}

	@Override
	public void updateOrder(FoodBean order) {
		getJdbcTemplate().update("UPDATE FoodOrder SET id=?, comments=?, mycheck=?, sideId=?, menuId=? WHERE id=?", new Object[]{order.getID(),order.getComment(), order.getCheck(), order.getSideID(), order.getMenuID(), order.getID()});
	}

	@Override
	public int getOrderCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addOrder(FoodBean order) {
		getJdbcTemplate().update("INSERT INTO FoodOrder(comments, mycheck, sideId, menuId) VALUES(?,?,?,?)",new Object[]{order.getComment(), order.getCheck(), order.getSideID(), order.getMenuID()});
	}
	
	@Override
	public long addOrderGetId(FoodBean order){
		getJdbcTemplate().update("INSERT INTO FoodOrder(comments, mycheck, sideId, menuId) VALUES(?,?,?,?)",new Object[]{order.getComment(), order.getCheck(), order.getSideID(), order.getMenuID()});
		long id = (long) getJdbcTemplate().queryForInt("Select MAX(id) from FoodOrder");		
		return id;
		
	}

	@Override
	public List<FoodBean> getFoodsListByCheck(CheckBean check) {
		List<FoodBean> foodList = getJdbcTemplate().query("SELECT id, menuId, comments, mycheck, sideId FROM FoodOrder WHERE mycheck=?", new Object[]{check.getID()}, new FoodOrderRowMapper());
		return foodList;
	}

}
