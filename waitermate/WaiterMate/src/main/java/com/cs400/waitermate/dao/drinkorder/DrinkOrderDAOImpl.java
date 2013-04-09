package com.cs400.waitermate.dao.drinkorder;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.DrinkBean;
import com.cs400.waitermate.beans.OrderBean;
import com.cs400.waitermate.dao.order.OrderRowMapper;
import com.cs400.waitermate.dao.order.IOrderDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;




public class DrinkOrderDAOImpl extends JdbcDaoSupport implements IDrinkOrderDAO {

	

	@Override
	public HashMap<String, DrinkBean> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DrinkBean> getOrderList() {
		List<DrinkBean> tempBean = getJdbcTemplate().query("SELECT id, comment, check, abv, menuId FROM DrinkOrder", new DrinkOrderRowMapper());
		return tempBean;
	}

	@Override
	public DrinkBean getOrderById(DrinkBean order) {
		DrinkBean tempBean = (DrinkBean)getJdbcTemplate().queryForObject("SELECT id, comment, check, abv, menuId FROM DrinkOrder WHERE id=?", new Object[]{order.getID()}, new DrinkOrderRowMapper());
		return tempBean;
	}

	@Override
	public void deleteOrder(DrinkBean order) {
		getJdbcTemplate().update("DELETE FROM DrinkOrder WHERE id=?", new Object[]{order.getID()});		
	}

	@Override
	public void updateOrder(DrinkBean order) {
		getJdbcTemplate().update("UPDATE DrinkOrder SET id=?, comment=?, check=?, abv=?, menuId=? WHERE id=?", new Object[]{order.getID(),order.getComment(), order.getCheck(), order.getAbv(), order.getMenuID(), order.getID()});		
	}

	@Override
	public int getOrderCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addOrder(DrinkBean order) {
		getJdbcTemplate().update("INSERT INTO DrinkOrder(id, comment, check, abv, menuId) VALUES(?,?,?,?,?)",new Object[]{order.getID(),order.getComment(), order.getCheck(), order.getAbv(), order.getMenuID()});
		
	}

}
