package com.cs400.waitermate.dao.check;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.dao.check.CheckRowMapper;
import com.cs400.waitermate.dao.check.ICheckDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class CheckDAOImpl extends JdbcDaoSupport implements ICheckDAO {

	@Override
	public HashMap<String, CheckBean> getChecks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckBean> getCheckList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckBean getCheckById(CheckBean check) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCheck(CheckBean check) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCheck(CheckBean check) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCheckCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addCheck(CheckBean check) {
		// TODO Auto-generated method stub
		
	}

}
