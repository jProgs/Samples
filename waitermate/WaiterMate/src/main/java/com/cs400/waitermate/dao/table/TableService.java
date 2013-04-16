package com.cs400.waitermate.dao.table;

import java.util.List;

import java.util.Date;
import java.util.ArrayList;

import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.beans.TableBean;
import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.WaiterBean;
import com.cs400.waitermate.dao.check.ICheckDAO;
import com.cs400.waitermate.dao.foodorder.FoodOrderRowMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TableService implements ITableService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
	private ITableDAO dao = (ITableDAO) context.getBean("ITableDAO");
	
	@Override
	public List<TableBean> listTables() {
		return dao.getTablesList();
	}

	@Override
	public void addTable(TableBean table) {
		dao.addTable(table);		
	}

	@Override
	public void removeTable(TableBean table) {
		dao.deleteTable(table);
	}

	@Override
	public TableBean findTableById(TableBean table) {
		return dao.getTableById(table);
	}

	@Override
	public void editTable(TableBean table) {
		dao.updateTable(table);
	}

	// NEED TO IMPLEMENTS THIS, MAYBE SOMEWHERE ELSE
	@Override
	public List<CheckBean> getTableCheckList(int tableId) {
		List<CheckBean> checkList = new ArrayList<CheckBean>();
		
		
		
		
		return checkList;		
	}
	// NEED TO IMPLEMENTS THIS, MAYBE SOMEWHERE ELSE
	@Override
	public CheckBean getSpecificCheck(long checkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TableBean> getTablesByWaiter(WaiterBean waiter) {
		List<TableBean> tableList = new ArrayList<TableBean>();
		tableList = dao.getTablesByWaiter(waiter);
		return tableList;
	}

}
