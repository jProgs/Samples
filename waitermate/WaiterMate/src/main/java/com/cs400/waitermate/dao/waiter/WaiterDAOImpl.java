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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WaiterBean getWaiterById(WaiterBean waiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteWaiter(WaiterBean waiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWaiter(WaiterBean waiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWaiterCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addWaiter(WaiterBean waiter) {
		// TODO Auto-generated method stub
		
	}

}
