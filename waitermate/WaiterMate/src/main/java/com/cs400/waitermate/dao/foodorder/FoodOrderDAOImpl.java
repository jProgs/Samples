package com.cs400.waitermate.dao.foodorder;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

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
		List<FoodBean> tempBean = getJdbcTemplate().query("SELECT id, menuId, comment, check, sideId FROM FoodOrder", new FoodOrderRowMapper());
		return tempBean;
	}

	@Override
	public FoodBean getOrderById(FoodBean order) {
		FoodBean tempBean = (FoodBean)getJdbcTemplate().queryForObject("SELECT id, comment, check, sideId, menuId FROM FoodOrder WHERE id=?", new Object[]{order.getID()}, new FoodOrderRowMapper());
		return tempBean;
	}

	@Override
	public void deleteOrder(FoodBean order) {
		getJdbcTemplate().update("DELETE FROM FoodOrder WHERE id=?", new Object[]{order.getID()});
	}

	@Override
	public void updateOrder(FoodBean order) {
		getJdbcTemplate().update("UPDATE FoodOrder SET id=?, comment=?, check=?, sideId=?, menuId=? WHERE id=?", new Object[]{order.getID(),order.getComment(), order.getCheck(), order.getSideID(), order.getMenuID(), order.getID()});
	}

	@Override
	public int getOrderCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addOrder(FoodBean order) {
		getJdbcTemplate().update("INSERT INTO FoodOrder(id, comment, check, sideId, menuId) VALUES(?,?,?,?,?)",new Object[]{order.getID(),order.getComment(), order.getCheck(), order.getSideID(), order.getMenuID()});
	}

}
