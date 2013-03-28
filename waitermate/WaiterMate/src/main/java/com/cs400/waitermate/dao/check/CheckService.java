package com.cs400.waitermate.dao.check;

import java.util.List;
import java.util.ArrayList;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.dao.check.CheckRowMapper;

public class CheckService implements ICheckService {

	private ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring-Module.xml");
	private ICheckDAO dao = (ICheckDAO) context.getBean("ICheckDAO");
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CheckBean> listChecks() {
		return dao.getCheckList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void addCheck(CheckBean check) {
		dao.addCheck(check);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void removeCheck(CheckBean check) {
		dao.deleteCheck(check);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public CheckBean findCheckById(CheckBean check) {
		return dao.getCheckById(check);
	}

	@Override
	public void editCheck(CheckBean check) {
		dao.updateCheck(check);
	}

	@Override
	public long getNextCheckId() {
		// TODO Figure out how to map results to a long
		//long checkID = getJdbcTemplate().query("SELECT MAX(ID) FROM Check");
		return 0;
	}

}
