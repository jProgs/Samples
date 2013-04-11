package com.cs400.waitermate.dao.waiter;

import java.util.List;

import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.beans.WaiterBean;
import com.cs400.waitermate.dao.foodorder.FoodOrderRowMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class WaiterService implements IWaiterService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
	private IWaiterDAO dao = (IWaiterDAO) context.getBean("IWaiterDAO");

	@Override
	public List<WaiterBean> listWaiters() {
		return dao.getWaitersList();
	}

	@Override
	public void addWaiter(WaiterBean waiter) {
		dao.addWaiter(waiter);
	}

	@Override
	public void removeWaiter(WaiterBean waiter) {
		dao.deleteWaiter(waiter);
	}

	@Override
	public WaiterBean findWaiterById(WaiterBean waiter) {
		return dao.getWaiterById(waiter);
	}

	@Override
	public void editWaiter(WaiterBean waiter) {
		dao.updateWaiter(waiter);
	}

	@Override
	public boolean testWaiterLogIn(WaiterBean waiter) {
		boolean go = false;
		go = dao.testWaiterLogIn(waiter);
		return go;
		
	}

	@Override
	public boolean testWaiterAdminLogIn(WaiterBean waiterBean) {
		// TODO Auto-generated method stub
		return false;
	}

}
